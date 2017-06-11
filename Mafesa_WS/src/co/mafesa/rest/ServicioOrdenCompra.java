package co.mafesa.rest;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.mafesa.bl.DetalleOrdenCompraBL;
import co.mafesa.bl.OrdenCompraBL;
import co.mafesa.dto.OrdenCompra;
import co.mafesa.exception.MyException;
/**
 * Implementacion de los servicios web de la logica de negocio para la orden de compra
 * @author Maria Alejandra Cadavid Osorio - mariaa.cadavid@udea.edu.co
 *
 */
@Path("OrdenCompra")
@Component
public class ServicioOrdenCompra {
	@Autowired
	private OrdenCompraBL ordenCompraService;
	private DetalleOrdenCompraBL detalleService;
	
	/**
	 * Metodo para obtener lista de ordenes de compra
	 * @return lista de ordenes de compra
	 * @throws RemoteException cuando un error retornando la lista de ordenes de compra
	 */
	@Path("list")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public List<OrdenCompra> obtener() throws RemoteException{
		List<OrdenCompra> ordenesCompra = new ArrayList<OrdenCompra>();
		List<OrdenCompra> listaOrdenesCompra = null;
		
		try{
			listaOrdenesCompra = ordenCompraService.obtenerLista();
				for(OrdenCompra ordenCompra: listaOrdenesCompra){
					OrdenCompra ordenCompraWS = new OrdenCompra();
					ordenCompraWS.setNumero(ordenCompra.getNumero());
					ordenCompraWS.setCliente(ordenCompra.getCliente());
					ordenCompraWS.setFormaPago(ordenCompra.getFormaPago());
					ordenCompraWS.setPlazoEntrega(ordenCompra.getPlazoEntrega());
					ordenCompraWS.setFechaEntrega(ordenCompra.getFechaEntrega());
					ordenCompraWS.setDireccionEntrega(ordenCompra.getDireccionEntrega());
					ordenCompraWS.setValorTotal(ordenCompra.getValorTotal());
					ordenCompraWS.setUsuarioCrea(ordenCompra.getUsuarioCrea());
					ordenCompraWS.setFechaCreacion(ordenCompra.getFechaCreacion());
				
					
					ordenesCompra.add(ordenCompraWS);
				}
			}catch(MyException e){
				throw new RemoteException(e.getMessage());
			}

		return ordenesCompra;
	}
	
	/**
	 * Metodo que permite registrar una orden de compra
	 * @param numOrdenCompra numero de orden de compra
	 * @param cliente cliente
	 * @param formaPago forma de pago
	 * @param plazoEntrega plazo de entrega
	 * @param fechaEntrega fecha de entrega
	 * @param direccionEntrega direccion de entrega
	 * @param valorTotal valor total
	 * @param usuarioCrea usuario que registra
	 * @return mensaje de confirmacion
	 * @throws RemoteException cuando hay un error registrando una orden de compra
	 * @throws NumberFormatException
	 * @throws ParseException
	 */
	@Produces(MediaType.TEXT_PLAIN)
	@POST
	public String registrarOrdenCompra(@QueryParam("numOrdenCompra")String numOrdenCompra, @QueryParam("cliente")String cliente,
			@QueryParam("formaPago")String formaPago, @QueryParam("plazoEntrega")String plazoEntrega, 
			@QueryParam("fechaEntrega")String fechaEntrega, @QueryParam("direccionEntrega")String direccionEntrega, 
			@QueryParam("valorTotal")String valorTotal, @QueryParam("usuarioCrea")String usuarioCrea) throws RemoteException, NumberFormatException, ParseException{
		try{
			ordenCompraService.registrarOrdenCompra(numOrdenCompra, cliente, formaPago, plazoEntrega, fechaEntrega, direccionEntrega,valorTotal, usuarioCrea);
			
		}catch(MyException e){
			return e.getMessage();
		}
		
		return "";
	}
	
	/**
	 * Metodo para modificar una orden de compra
	 * @param numOrdenCompra numero de orden de compra
	 * @param cliente cliente
	 * @param formaPago forma de pago
	 * @param plazoEntrega plazo de entrega
	 * @param fechaEntrega fecha de entrega
	 * @param direccionEntrega direccion de entrega
	 * @param valorTotal valor total
	 * @param usuarioCrea usuario que registra
	 * @return mensaje de confirmacion
	 * @throws RemoteException cuando hay un error modificando una orden de compra
	 * @throws NumberFormatException
	 * @throws ParseException
	 */
	@Path("update")
	@Produces(MediaType.TEXT_PLAIN)
	@PUT
	public String modificarOrdenCOmpra(@QueryParam("numOrdenCompra")String numOrdenCompra, @QueryParam("cliente")String cliente,
			@QueryParam("formaPago")String formaPago, @QueryParam("plazoEntrega")String plazoEntrega, 
			@QueryParam("fechaEntrega")String fechaEntrega, @QueryParam("direccionEntrega")String direccionEntrega, 
			@QueryParam("valorTotal")String valorTotal, @QueryParam("usuarioModifica")String usuarioModifica) throws RemoteException, ParseException{
		try{
			ordenCompraService.modificarOrdenCompra(numOrdenCompra, cliente, formaPago, plazoEntrega, fechaEntrega, direccionEntrega, valorTotal, usuarioModifica);
			
			
		}catch(MyException e){
			return e.getMessage();
		}
		
		return "";
	}
	
	/**
	 * Metodo que permite eliminar una orden de compra
	 * @param numOrdenCompra numero de orden de compra
	 * @param usuarioEliminado usuario que realiza la eliminacion
	 * @return mensaje de confirmacion
	 * @throws RemoteException cuando hay un error eliminando una orden de comrpa
	 */
	@Path("delete")
	@Produces(MediaType.TEXT_PLAIN)
	@DELETE
	public String eliminarOrdenCompra(@QueryParam("numOrdenCompra")String numOrdenCompra,@QueryParam("usuarioEliminado")String usuarioEliminado) throws RemoteException{
		try{
			ordenCompraService.eliminarOrdenCompra(numOrdenCompra, usuarioEliminado);
			
		}catch(MyException e){
			return e.getMessage();
		}
		
		return "";
	}
	
	/**
	 * Busca una orden de compra
	 * @param numOrdenCompra numero de orden de compra
	 * @return mensaje de confirmacion
	 * @throws RemoteException cuando hay un error buscando una orden de compra
	 */
	@Path("search")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public OrdenCompra buscarOrdenCompra(@QueryParam("numOrdenCompra")String numOrdenCompra) throws RemoteException{
		OrdenCompra ordenCompra = new OrdenCompra();
		try{
			ordenCompra = ordenCompraService.buscarOrdenCompra(numOrdenCompra);
			
		}catch(MyException e){
			throw new RemoteException(e.getMessage());
		}
		
		return ordenCompra;
	}
	

	/**
	 * Metodo para ingresar un detalle
	 * @param numero numero de detalle
	 * @param numOrdenCompra numero de orden de compra
	 * @param refServicio referencia de servicio
	 * @param cantidad cantidad
	 * @param valor valor
	 * @param observaciones observaciones
	 * @return mensaje de confirmacion
	 * @throws RemoteException cuando hay un error ingresando un detalle
	 */
	@Path("detalle")
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	public String ingresarDetalle(@QueryParam("numero")String numero, @QueryParam("numOrdenCompra")String numOrdenCompra,
			@QueryParam("refServicio")String refServicio, @QueryParam("cantidad")String cantidad, 
			@QueryParam("valor")String valor, @QueryParam("observaciones")String observaciones) throws RemoteException{
		try{
			detalleService.insertarDetalleOrdenCompra(numero, numOrdenCompra, refServicio, cantidad, valor, observaciones);
			return "Detalle guardado correctamente";
		}catch(MyException e){
			return e.getMessage();
		}
	}
	
	
}
