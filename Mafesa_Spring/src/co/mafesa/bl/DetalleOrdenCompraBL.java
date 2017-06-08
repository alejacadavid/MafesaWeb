package co.mafesa.bl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import co.mafesa.dto.DetalleOrdenCompra;
import co.mafesa.exception.MyException;

/**
 * Contienen los métodos de la lógica del negocio para la entidad Detalle de Orden de Compra
 * @author Maria Alejandra Cadavid Osorio - mariaa.cadavid@udea.edu.co
 *
 */
@Transactional
public interface DetalleOrdenCompraBL {
	/**
	 * Retorna la lista de los detalle de orden de compra
	 * @return lista de detalles 
	 * @throws MyException cuando hay un error obteniendo la lista
	 */
	public List<DetalleOrdenCompra> obtenerLista() throws MyException;
	
	/**
	 * Permite insertar un detalle de una orden de compra
	 * @param numero numero de detalle
	 * @param numOrdenCompra numero de orden de compra
	 * @param refServicio referencia del servicio
	 * @param cantidad cantidad
	 * @param valor valor
	 * @param observaciones observaciones
	 * @throws MyException cuando hay un error insertarndo un detalle de una orden de compra
	 */
	public void insertarDetalleOrdenCompra(String numero, String numOrdenCompra, String refServicio, String cantidad,
			String valor, String observaciones) throws MyException;

	/**
	 * Elimina detalles de una orden de compra
	 * @param numero numero de detalle
	 * @throws MyException cuando hay un error eliminando detalles de una orden de compra
	 */
	public void eliminarDetalleOrdenCompra(String numero) throws MyException;

	/**
	 * Modifica el detalle de una orden de compra
	 * @param numero numero de detalle
	 * @param numOrdenCompra numero de orden de compra
	 * @param refServicio referencia de servicio
	 * @param cantidad cantidad
	 * @param valor valor
	 * @param observaciones observaciones
	 * @throws MyException cuando hay un error modificando un detalle de una orden de compra
	 */
	public void modificarDetalleOrdenCompra(String numero, String numOrdenCompra, String refServicio, String cantidad,
			String valor, String observaciones) throws MyException;
	
}
