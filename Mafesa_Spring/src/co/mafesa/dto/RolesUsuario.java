package co.mafesa.dto;

/**
 * DTO para la tabla Roles por usuario
 * @author Maria Alejandra Cadavid Osorio - mariaa.cadavid@udea.edu.co
 * @since Java 1.7
 * @version 1.0
 */

public class RolesUsuario {

	private int codigo;
	private Rol rol;
	private Usuario usuario;

	/**
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return el rol
	 */
	public Rol getRol() {
		return rol;
	}
	/**
	 * @param rol el rol a ingresar
	 */
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	/**
	 * @return el usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario el usuario a ingresar
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
