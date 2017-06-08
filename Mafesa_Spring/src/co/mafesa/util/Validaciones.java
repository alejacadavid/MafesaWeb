package co.mafesa.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase para validaciones en general del sistema
 * @author Maria Alejandra Cadavid Osorio - mariaa.cadavid@udea.edu.co
 *
 */
public class Validaciones {

	private static final String PATTERN_EMAIL ="^[_a-z0-9-]+(.[_a-z0-9-]+)*@[a-z0-9-]+(.[a-z0-9-]+)*(.[a-z]{2,4})$";
	
	/**
	 * Valida que el correo electrónico establecido como parámetro sea un correo electrónico con formato válido
	 * @param email texto con el correo electrónico a validar
	 * @return true si el texto tiene un formato de correo electrónico válido, de lo contrario retorna false
	 */
	public static boolean isEmail(String email){
		
		Pattern pattern = Pattern.compile(PATTERN_EMAIL);
		
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
}
