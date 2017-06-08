package co.mafesa.bl;

import java.text.ParseException;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import co.mafesa.dto.OrdenCompra;
import co.mafesa.exception.MyException;

/**
 * Contienen los métodos de la lógica del negocio para la entidad OrdenCompra
 * @author Maria Alejandra Cadavid Osorio - mariaa.cadavid@udea.edu.co
 *
 */
@Transactional
public interface OrdenCompraBL {

	/**
	 * Retorna la lista de las ordenes de compra
	 * @return lista de ordenes de compra
	 * @throws MyException cuando hay errores retorna las ordenes de compra
	 */
	public List<OrdenCompra> obtenerLista() throws MyException;
	
	/**
	 * Permite registrar una orden de compra
	 * @param numOrdenCompra numero de orden de compra
	 * @param cliente cliente
	 * @param formaPago forma de pago
	 * @param plazoEntrega plazo de entrega
	 * @param fechaEntrega fecha de entrega
	 * @param direccionEntrega direccion de entrega
	 * @param valorTotal valor total
	 * @param usuarioCrea usuario que crea la orden de comrpa
	 * @throws MyException cuando hay erroes registrando una orden de comrpa
	 * @throws ParseException cuando hay errores convirtiendo tipos
	 */
	public void registrarOrdenCompra(String numOrdenCompra, String cliente, String formaPago, String plazoEntrega,
			String fechaEntrega, String direccionEntrega, String valorTotal, String usuarioCrea) throws MyException, ParseException;

	/**
	 * Elimina una orden de compra
	 * @param numOrdenCompra numero de orden de compra
	 * @param usuarioEliminado usuario que elimina una orden de compra
	 * @throws MyException cuando hay errores eliminando una orden de compra
	 */
	public void eliminarOrdenCompra(String numOrdenCompra, String usuarioEliminado) throws MyException;

	/**
	 * Modifica la información de una orden de compra
	 * @param numOrdenCompra numero de orden de compra
	 * @param cliente cliente
	 * @param formaPago forma de pago
	 * @param plazoEntrega plazo de entrega
	 * @param fechaEntrega fecha de entrega
	 * @param direccionEntrega direccion de entrega
	 * @param valorTotal valor total
	 * @param usuarioCrea usuario que crea la orden de comrpa
	 * @throws MyException cuando hay erroes modificando una orden de comrpa
	 * @throws ParseException cuando hay errores convirtiendo tipos
	 */
	public void modificarOrdenCompra(String numOrdenCompra, String cliente, String formaPago, String plazoEntrega,
			String fechaEntrega, String direccionEntrega, String valorTotal, String usuarioModifica) throws MyException, ParseException;

	/**
	 * Busca una orden de compra por su numero
	 * @param numOrdenCompra numero de orden de compra
	 * @return orden de compra
	 * @throws MyException cuando hay errores buscando una orden de compra
	 */
	public OrdenCompra buscarOrdenCompra(String numOrdenCompra) throws MyException;
	
	
}
