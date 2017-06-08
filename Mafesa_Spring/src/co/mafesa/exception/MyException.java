package co.mafesa.exception;


/**
 * Clase con los métodos necesarios para capturar excepciones 
 * @author Maria Alejandra Cadavid Osorio - mariaa.cadavid@udea.edu.co
 * @since Java 1.7
 * @version 1.0
 */
public class MyException extends Exception {

	/**
	 * Constructor de una nueva excepción cuando recibe null en el mensaje 
	 */
	public MyException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de una nueva excepción con el mensaje de detalle especificado
	 * @param arg0 mensaje
	 */
	public MyException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de una nueva excepción con la causa
	 * @param arg0 causa
	 */
	public MyException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * Constructor de una nueva excepción con el mensaje especificado y la causa
	 * @param arg0 mensaje
	 * @param arg1 causa
	 */
	public MyException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de una nueva excepción con el mensaje especificado, la causa, 
	 * supression habiltitada o deshabilitada y stack trace habilitada o deshabilitada
	 * @param arg0 mensaje
	 * @param arg1 causa
	 * @param arg2 Si supression está habilitado o no
	 * @param arg3 Si stack trace está habilitado o no
	 */
	public MyException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

}
