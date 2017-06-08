package co.mafesa.dto;

/**
 * DTO para la tabla Rol
 * @author Maria Alejandra Cadavid Osorio - mariaa.cadavid@udea.edu.co
 * @since Java 1.7
 * @version 1.0
 */

public class Rol {

	private String codigo;
	private String nombre;
	
	/**
	 * @return El código
	 */
	public String getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo el código a ingresar
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return El nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre El nombre a ingresar
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
