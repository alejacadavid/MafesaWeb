package co.mafesa.dao;

import java.util.List;

import co.mafesa.dto.Cliente;
import co.mafesa.exception.MyException;

/**
 * Interface que define los métodos permitidos para los Clientes en el 
 * sistema
 * @author Maria Alejandra Cadavid Osorio - mariaa.cadavid@udea.edu.co
 * @since Java 1.7
 * @version 1.0
 */
public interface ClienteDAO {
	/**
	 * Obtiene la lista de clientes que existen en el sistema 
	 * @return Lista de clientes
	 * @throws MyException ocurre cuando hay un problema con la conexión a la BD
	 */
	public List<Cliente> get() throws MyException;
	
	/**
	 * Inserta la información de un Cliente
	 * @param cliente cliente
	 * @throws MyException ocurre cuando hay un problema con la conexión a la BD
	 */
	public void insert(Cliente cliente) throws MyException;
	
	/**
	 * Entrega la información de un cliente dado su id
	 * @param codigo del cliente
	 * @return datos del cliente
	 * @throws MyException cuando hay un error consultado
	 */
	public Cliente get(String codigoCliente) throws MyException;
	
	/**
	 * Modifca los datos de un cliente en la base de datos
	 * @param cliente objeto {@link Cliente} con la información a modificar
	 * @throws MyException cuando hay un error modificando la información
	 */
	public void update(Cliente cliente) throws MyException;
	
	/**
	 * Elimina los datos de un cliente en la base de datos
	 * @param cliente objeto {@link Cliente} con la informacion a eliminar
	 * @throws MyException cuando hay un error eliminando la informacion
	 */
	public void delete(Cliente cliente) throws MyException;
	
}
