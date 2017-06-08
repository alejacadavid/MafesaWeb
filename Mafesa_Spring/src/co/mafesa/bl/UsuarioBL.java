package co.mafesa.bl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;


import co.mafesa.dto.Usuario;
import co.mafesa.exception.MyException;
/**
 * Contienen los métodos de la lógica del negocio para la entidad Usuario
 * @author Maria Alejandra Cadavid Osorio - mariaa.cadavid@udea.edu.co
 *
 */
@Transactional
public interface UsuarioBL {
	/**
	 * Permite la autenticación en el sistema
	 * @param nombreUsuario nombre de usuario
	 * @param pws contraseña
	 * @throws MyException cuando hay errores en la autenticación 
	 */
	public void autenticar(String nombreUsuario, String pws) throws MyException;
	
	/**
	 * Permite guardar usuarios
	 * @param nombreUsuario nombre de usuario
	 * @param tipoId tipo de identificacion
	 * @param numeroId numero de identificacion
	 * @param nombres nombres
	 * @param apellidos apellidos
	 * @param direccion direccion
	 * @param telefono telefono
	 * @param email email
	 * @param contraseña contraseña
	 * @param fechaCreacion fecha de creacion
	 * @param cliente cliente
	 * @throws MyException cuando ocurre un error al guardar
	 */
	public void registrarUsuario(String nombreUsuario, String tipoId, String numeroIdentificacion, 
			String nombres, String apellidos, String direccion, String telefono, String email,String contraseña,
			String Cliente) throws MyException;
	
	/**
	 * Retorna la lista de usuarios
	 * @return lista de usuarios
	 * @throws MyException cuando hay un error retornando la lista de usuarios
	 */
	public List<Usuario> obtenerLista() throws MyException;
	
	/**
	 * Elimina un usuario
	 * @param nombreUsuario nombre de usuario
	 * @throws MyException cuando hay un error elimianndo un usuario
	 */
	public void eliminarUsuario(String nombreUsuario) throws MyException;

	/**
	 * Actualiza la informacion de un usuario
	 * @param nombreUsuario nombre de usuario
	 * @param tipoId tipo de identificacion
	 * @param numeroId numero de identificacion
	 * @param nombres nombres
	 * @param apellidos apellidos
	 * @param direccion direccion
	 * @param telefono telefono
	 * @param email email
	 * @param contraseña contraseña
	 * @param fechaCreacion fecha de crea
	 * @throws MyException cuando hay un error actualizando la informacion de un usuario
	 */
	public void actualizarUsuario(String nombreUsuario, String tipoId, String numeroIdentificacion, 
			String nombres, String apellidos, String direccion, String telefono, String email,String contraseña,
			String cliente) throws MyException;

	/**
	 * Busca un usuario por su nombre
	 * @param nombreUsuario nombre de usuario
	 * @return usuario
	 * @throws MyException cuando hay un error buscando un usuario
	 */
	public Usuario buscarUsuario(String nombreUsuario) throws MyException;
}
