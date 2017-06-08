package co.mafesa.dao;

import java.util.List;


import co.mafesa.dto.DetalleOrdenCompra;
import co.mafesa.dto.Estado;
import co.mafesa.exception.MyException;

public interface DetalleOrdenCompraDAO {

	public List<DetalleOrdenCompra> get() throws MyException;
	/**
	 * Inserta la información de un Estado
	 * @param estado estado
	 * @throws MyException cuando hay un error insertando
	 */
	public void insert(DetalleOrdenCompra detalleOrdenCompra) throws MyException;

	/**
	 * Entrega la información del estado de una orden de compra dado su numero
	 * @param numero numero de estado
	 * @return estado
	 * @throws MyException cuando hay un error consultando
	 */
	public DetalleOrdenCompra get(int numero) throws MyException;

	/**
	 * Modifca los datos del estado de una orden de compra en la base de datos
	 * @param estado objeto {@link Estado} con la información a modificar
	 * @throws MyException cuando hay un error modificando la información
	 */
	public void update(DetalleOrdenCompra detalleOrdenCompra) throws MyException;

	/**
	 * Elimina los datos del estado de una orden de compra en la base de datos
	 * @param estado objeto {@link Estado} con la información a modificar
	 * @throws MyException  cuando hay un error eliminando la información
	 */
	public void delete(DetalleOrdenCompra detalleOrdenCompra) throws MyException;

}
