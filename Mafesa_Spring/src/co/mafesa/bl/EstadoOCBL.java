package co.mafesa.bl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import co.mafesa.dto.EstadoOC;
import co.mafesa.exception.MyException;
/**
 * Contienen los métodos de la lógica del negocio para la entidad Estado de Orden de Compra
 * @author Maria Alejandra Cadavid Osorio - mariaa.cadavid@udea.edu.co
 *
 */
@Transactional
public interface EstadoOCBL {

	/**
	 * Retorna la lista de estados de ordenes de compra
	 * @return lista de estados de ordenes de compra
	 * @throws MyException cuando hay un error retornando la lista
	 */
	public List<EstadoOC> obtenerLista() throws MyException;
	
	/**
	 * Inserta un estado de una orden de compra
	 * @param numero numero de estado
	 * @param estado estado
	 * @param usuario usuario
	 * @param cantidadPendiente cantidad pendiente
	 * @param cantidadProcesada cantidad procesada
	 * @param ordenCompra orden de compra
	 * @throws MyException cuando hay un error insertando un estado de una orden de compra
	 */
	public void insertarEstadoOC(String numero, String estado, String usuario, String cantidadPendiente,
			String cantidadProcesada, String ordenCompra) throws MyException;

	/**
	 * Elimina un estado de una orden de compra
	 * @param numero numero de estado
	 * @throws MyException cuando hay un error eliminando un estado
	 */
	public void eliminarEstadoOC(String numero) throws MyException;

	/**
	 * Modifica un estado de una orden de compra
	 *  @param numero numero de estado
	 * @param estado estado
	 * @param usuario usuario
	 * @param cantidadPendiente cantidad pendiente
	 * @param cantidadProcesada cantidad procesada
	 * @param ordenCompra orden de compra
	 * @throws MyException cuando hay un error modificando un estado
	 */
	public void modificarEstadoOC(String numero, String estado, String usuario, String cantidadPendiente,
			String cantidadProcesada, String ordenCompra) throws MyException;
}
