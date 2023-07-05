package org.menuprincipal;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import org.View.ControladorDescripcionPersona;
import org.View.ControladorVentanaEdicionPersona;
import javafx.stage.Modality;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.openjpa.control.PersonaControl;

import org.openjpa.control.exceptions.EntidadPreexistenteException;
import org.openjpa.entidades.Persona;




public class MenuPrincipal extends Application {
    
    
    /**
     * Los datos como lista observable de Personas.
     */
    Persona persona;
    private ObservableList<Persona> DatosPersona = FXCollections.observableArrayList();
    /**
     * Constructor
     */
    
    public MenuPrincipal() {
	// Agregando algo de daotos
        DatosPersona.add(new Persona("Hans", "Muster"));
	DatosPersona.add(new Persona("Ruth", "Mueller"));
	DatosPersona.add(new Persona("Heinz", "Kurz"));
	DatosPersona.add(new Persona("Cornelia", "Meier"));
	DatosPersona.add(new Persona("Werner", "Meyer"));
	DatosPersona.add(new Persona("Lydia", "Kunz"));
	DatosPersona.add(new Persona("Anna", "Best"));
	DatosPersona.add(new Persona("Stefan", "Meier"));
	DatosPersona.add(new Persona("Martin", "Mueller"));
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BaseDatos");
        PersonaControl personaControl = new PersonaControl(emf);
        // Pedimos datos del autor
        String nombre = leerTexto("Introduce nombre: ");
        String apellidos = leerTexto("Introduce apellidos: ");
        String email = leerTexto("Introduce el correo electrónico: ");
        persona = new Persona(nombre, apellidos, email);
        try {
            // Lo añadimos a la BD
            System.out.println("Identificador del autor: " + personaControl.insertar(persona));
        } catch (EntidadPreexistenteException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Persona> results = personaControl.buscaPersonas();
        for(Persona p : results){
            System.out.println(p);
        }
    
    }
  
    /**
     * Devuelve los datos como una lista observable de Personas.
     * @return
     */
    public ObservableList<Persona> getPersonData() {
	return DatosPersona;
    }
    private Stage primaryStage;
    private BorderPane rootLayout;
    
    

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("ExampleOne");

        initModeloRaiz();

        showVistaPersona();
    }
    
    public void initModeloRaiz() {
        try {
            // Carga el diceño raiz desde al archivo FXML
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MenuPrincipal.class.getResource("/View/ModeloRaiz.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the person overview inside the root layout.
     */
    public void showVistaPersona() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MenuPrincipal.class.getResource("/View/VistaPersona.fxml"));
            AnchorPane VistaPersona = (AnchorPane) loader.load();
            
            // Set person overview into the center of root layout.
            rootLayout.setCenter(VistaPersona);
            // Give the controller access to the main app.
            ControladorDescripcionPersona controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
    * Abre un cuadro de diálogo para editar los detalles de la persona especificada. Si el usuario
    * hace clic en Aceptar, los cambios se guardan en el objeto de persona proporcionado y son verdaderos
    * es regresado.
    *
    * @param person el objeto persona a editar
    * @return verdadero si el usuario hizo clic en Aceptar, falso en caso contrario.
    */
    public boolean showPersonEditDialog(Persona person) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MenuPrincipal.class.getResource("/View/VentanaEdicionPersona.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Person");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            ControladorVentanaEdicionPersona controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(person);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public Stage getPrimaryStage() {
	return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
    static private String leerTexto(String mensaje) {
        String texto;
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.print(mensaje);
            texto = in.readLine();
        } catch (IOException e) {
            texto = "Error";
        }
        return texto;
    }
}



/**
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.openjpa.control.MensajeControl;
import org.openjpa.control.PersonaControl;

import org.openjpa.control.exceptions.EntidadPreexistenteException;

import org.openjpa.entidades.Persona;
import org.openjpa.entidades.Mensaje;

*/
/*
public class MenuPrincipal {

    /**
     * @param args the command line arguments
     */
    /*public static void main(String[] args) {
        Persona persona;
        // Creamos la factoría de entity managers y un entity manager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BaseDatos");
        
        PersonaControl personaControl = new PersonaControl(emf);
        
        // Pedimos datos del autor
        String nombre = leerTexto("Introduce nombre: ");
        String apellidos = leerTexto("Introduce apellidos: ");
        String email = leerTexto("Introduce el correo electrónico: ");
        persona = new Persona(nombre, apellidos, email);
        try {
            // Lo añadimos a la BD
            System.out.println("Identificador del autor: " + personaControl.insertar(persona));
        } catch (EntidadPreexistenteException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Creamos el mensaje
        MensajeControl mensajeControl = new MensajeControl(emf);
        
        String mensajeStr = leerTexto("Introduce mensaje: ");
        Mensaje mens = new Mensaje(mensajeStr, persona);
        // Establecemos los campos
        mens.setFecha(new Date());
        // Y lo guardamos en la BD
        int idMensaje = 0;
        try {
            idMensaje = mensajeControl.insertar(mens);
        } catch (EntidadPreexistenteException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Identificador del mensaje: " + idMensaje);
        
        System.out.println("============================================");

        List<Persona> results = personaControl.buscaPersonas();
        for(Persona p : results){
            System.out.println(p);
        }
        
        System.out.println("============================================");
        // Marcamos el comienzo de la transacción
        

    }

    static private String leerTexto(String mensaje) {
        String texto;
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.print(mensaje);
            texto = in.readLine();
        } catch (IOException e) {
            texto = "Error";
        }
        return texto;
    }
}
*/