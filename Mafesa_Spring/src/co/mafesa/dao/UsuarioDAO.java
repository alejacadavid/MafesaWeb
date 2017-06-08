package co.mafesa.dao;

import java.util.List;

import co.mafesa.dto.Usuario;
import co.mafesa.exception.MyException;

/**
 * Interface que define los métodos permitidos para las Usuarios en el 
 * sistema
 * @author Maria Alejandra Cadavid Osorio - mariaa.cadavid@udea.edu.co
 * @since Java 1.7
 * @version 1.0
 */

public interface UsuarioDAO {

	/**
	 * Obtiene la lista de usuarios que existen en el sistema 
	 * @return Lista de usuarios
	 * @throws MyException ocurre cuando hay un problema con la conexión a la BD
	 */
	public List<Usuario> get() throws MyException;
	
	/**
	 * Entrega la información de un usuario dado su nombre de usuario
	 * @param usuario nombre de usuario
	 * @return datos del usuario
	 * @throws MyException cuando hay un error consultado
	 */
	public void insert(Usuario usuario) throws MyException;
	
	/**
	 * Entrega la información de un usuario dado su nombre de usuario
	 * @param usuario nombre de usuario
	 * @return datos del usuario
	 * @throws MyException cuando hay un error consultado
	 */
	public Usuario get(String usuario) throws MyException;
	
	/**
	 * Modifca los datos de un usuario en la base de datos
	 * @param usuario objeto {@link Usuario} con la información a modificar
	 * @throws MyException cuando hay un error modificando la información
	 */
	public void update(Usuario usuario) throws MyException;

	public void delete(Usuario usuario) throws MyException;
	
	
}
