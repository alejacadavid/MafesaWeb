package co.mafesa.dao;

import java.util.List;

import co.mafesa.dto.Cliente;
import co.mafesa.dto.OrdenCompra;
import co.mafesa.exception.MyException;

/**
 * Interface que define los métodos permitidos para una orden de compra
 * @author Maria Alejandra Cadavid Osorio - mariaa.cadavid@udea.edu.co
 * @since Java 1.7
 * @version 1.0
 */
public interface OrdenCompraDAO {

	/**
	 * Obtiene la lista de ordenes de compra que existen en el sistema 
	 * @return ordenes de compra
	 * @throws MyException ocurre cuando hay un problema con la conexión a la BD
	 */
	public List<OrdenCompra> get() throws MyException;

	/**
	 * Inserta la información de una orden de compra
	 * @param ordenCompra orden de compra
	 * @throws MyException cuando hay un error insertando
	 */
	public void insert(OrdenCompra ordenCompra) throws MyException;

	/**
	 * Entrega la información de una orden de compra dado su numero
	 * @param numero numero de orden de compra
	 * @return orden de compra
	 * @throws MyException cuando hay un error consultando
	 */
	public OrdenCompra get(int numero) throws MyException;

	/**
	 * Modifca los datos de una orden de compra en la base de datos
	 * @param ordenCompra objeto {@link OrdenCompra} con la información a modificar
	 * @throws MyException cuando hay un error modificando la información
	 */
	public void update(OrdenCompra ordenCompra) throws MyException;

	/**
	 * Elimina los datos de una orden de compra en la base de datos
	 * @param ordenCompra objeto {@link OrdenCompra} con la información a eliminar
	 * @throws MyException  cuando hay un error eliminando la información
	 */
	public void delete(OrdenCompra ordenCompra) throws MyException;
	
	
	
}
