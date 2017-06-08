package co.mafesa.dao;

import java.util.List;

import co.mafesa.dto.Rol;
import co.mafesa.exception.MyException;


/**
 * Interface que define los métodos permitidos para los roles en el 
 * sistema
 * @author Maria Alejandra Cadavid Osorio - mariaa.cadavid@udea.edu.co
 * @since Java 1.7
 * @version 1.0
 */
public interface RolDAO {
	/**
	 * Obtiene la lista de roles que existen en el sistema 
	 * @return Lista de roles
	 * @throws MyException ocurre cuando hay un problema con la conexión a la BD
	 */
	public List<Rol> get() throws MyException;

	/**
	 * Inserta la información de un rol
	 * @param rol rol
	 * @throws MyException cuando hay un error insertando
	 */
	public void insert(Rol rol) throws MyException;
	
	/**
	 * Entrega la información de un rol dado su codigo
	 * @param codigo codigo
	 * @return rol
	 * @throws MyException cuando hay un error consultando
	 */
	public Rol get(String codigo) throws MyException;

	/**
	 * Modifca los datos de un rol en la base de datos
	 * @param rol objeto {@link Rol} con la información a modificar
	 * @throws MyException cuando hay un error modificando la información
	 */
	public void update(Rol rol) throws MyException;
	
	/**
	 * Elimina los datos de un rol en la base de datos
	 * @param rol objeto {@link Rol} con la información a eliminar
	 * @throws MyException cuando hay un error eliminando la información
	 */
	public void delete(Rol rol) throws MyException;
	
}
