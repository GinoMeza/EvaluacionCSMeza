package org.openjpa.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
@Table(catalog = "openjpa", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "Persona.seleccionaTodos", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.seleccionaPorId", query = "SELECT p FROM Persona p WHERE p.personaId = :personaId"),
    @NamedQuery(name = "Persona.seleccionaPorApellidos", query = "SELECT p FROM Persona p WHERE p.apellidos = :apellidos")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "persona_id", nullable = false)
    private Integer personaId;

    @Column(length = 30)
    private String nombre;

    @Column(length = 60)
    private String apellidos;

    @Column(length = 50)
    private String correoElectronico;

    @Column(length = 100)
    private String direccion;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;

    @Column(length = 15)
    private String telefono;

    // JavaFX properties
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty street;
    private final StringProperty city;
    private final IntegerProperty postalCode;
    private final ObjectProperty<Date> birthday;

    public Persona(String hans, String muster) {
        this(null, null, null);
    }

    public Persona(String pNombre, String pApellidos, String pCorreoElectronico) {
        this.firstName = new SimpleStringProperty(pNombre);
        this.lastName = new SimpleStringProperty(pApellidos);
        this.street = new SimpleStringProperty("some street");
        this.postalCode = new SimpleIntegerProperty(1234);
        this.city = new SimpleStringProperty("some city");
        this.birthday = new SimpleObjectProperty<>(new Date(2005, 06, 15));
        this.nombre = pNombre;
        this.apellidos = pApellidos;
        this.correoElectronico = pCorreoElectronico;
        this.direccion = "direccion S/N";
        this.fechaNacimiento = new Date(2005, 06, 15);
        this.telefono = "999999999";
    }

    public Persona() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Integer getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Integer personaId) {
        this.personaId = personaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // JavaFX properties getters and setters
    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public String getStreet() {
        return street.get();
    }

    public void setStreet(String street) {
        this.street.set(street);
    }

    public StringProperty streetProperty() {
        return street;
    }

    public int getPostalCode() {
        return postalCode.get();
    }

    public void setPostalCode(int postalCode) {
        this.postalCode.set(postalCode);
    }

    public IntegerProperty postalCodeProperty() {
        return postalCode;
    }

    public String getCity() {
        return city.get();
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public StringProperty cityProperty() {
        return city;
    }

    public Date getBirthday() {
        return birthday.get();
    }

    public void setBirthday(Date birthday) {
        this.birthday.set(birthday);
    }

    public ObjectProperty<Date> birthdayProperty() {
        return birthday;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personaId != null ? personaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.personaId == null && other.personaId != null) || (this.personaId != null && !this.personaId.equals(other.personaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.openjpa.Persona[ personaId=" + personaId + " ]";
    }

}




/*package org.openjpa.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(catalog = "openjpa", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "Persona.seleccionaTodos", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.seleccionaPorId", query = "SELECT p FROM Persona p WHERE p.personaId = :personaId"),
    @NamedQuery(name = "Persona.seleccionaPorApellidos", query = "SELECT p FROM Persona p WHERE p.apellidos = :apellidos")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "persona_id", nullable = false)
    private Integer personaId;
    @Column(length = 30)
    private String nombre;
    @Column(length = 60)
    private String apellidos;
    @Column(length = 50)
    private String correoElectronico;
    @Column(length = 100)
    private String direccion;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    @Column(length = 15)
    private String telefono;
    public Persona() {
        this(null, null, null);
    }

    public Persona(String pNombre, String pApellidos, String pCorreoElectronico) {
        this.nombre = pNombre;
        this.apellidos = pApellidos;
        this.correoElectronico = pCorreoElectronico;
        this.direccion = "direccion S/N";
        this.fechaNacimiento = new Date(2005, 06, 15);
        this.telefono = "999999999";
    }

    public Persona(Integer personaId) {
        this.personaId = personaId;
    }

    public Integer getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Integer personaId) {
        this.personaId = personaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personaId != null ? personaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.personaId == null && other.personaId != null) || (this.personaId != null && !this.personaId.equals(other.personaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.openjpa.Persona[ personaId=" + personaId + " ]";
    }
    
}*/
