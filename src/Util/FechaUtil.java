package Util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Helper functions for handling dates.
 * 
 * @author Marco Jakob
 */
public class FechaUtil {
	
	/** El patrón de fecha que se utiliza para la conversión.. */
	private static final String DATE_PATTERN = "dd.MM.yyyy";
	
	/** El formateador de fechas. */
	private static final DateTimeFormatter DATE_FORMATTER = 
			DateTimeFormatter.ofPattern(DATE_PATTERN);
	
    /**
     * Devuelve la fecha dada como una cadena bien formateada. Lo anterior definido
     * Se utiliza {@link DateUtil#DATE_PATTERN}.
     *
     * @param date la fecha que se devolverá como una cadena
     * cadena con formato @return
     */
    public static String format(LocalDate date) {
        if (date == null) {
            return null;
        }
        return DATE_FORMATTER.format(date);
    }

    /**
     * Convierte una cadena en el formato del {@link DateUtil#DATE_PATTERN} definido
     * a un objeto {@link LocalDate}.
     *
     * Devuelve nulo si la cadena no se pudo convertir.
     *
     * @param dateString la fecha como String
     * @return el objeto de fecha o nulo si no se pudo convertir
     */
    public static LocalDate parse(String dateString) {
        try {
        	return DATE_FORMATTER.parse(dateString, LocalDate::from);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    /**
     * Comprueba la cadena si es una fecha válida.
     *
     * @param dateString de fecha
     * @return true si la cadena es una fecha válida
     */
    public static boolean validDate(String dateString) {
    	// Try to parse the String.
    	return FechaUtil.parse(dateString) != null;
    }
}