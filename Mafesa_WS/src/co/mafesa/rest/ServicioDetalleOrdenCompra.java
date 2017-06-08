package co.mafesa.rest;

import java.rmi.RemoteException;
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
import co.mafesa.dto.DetalleOrdenCompra;
import co.mafesa.exception.MyException;

/**
 * Implementacion de los servicios web de la logica de negocio para los detalles de la orden de compra
 * @author Maria Alejandra Cadavid Osorio - mariaa.cadavid@udea.edu.co
 *
 */
@Path("DetalleOrdenCompra")
@Component
public class ServicioDetalleOrdenCompra {
	
	@Autowired
	private DetalleOrdenCompraBL detalleOrdenCompraService;
	
	/**
	 * Metodo para retornar todos los detalles
	 * @return lista de detalles
	 * @throws RemoteException cuando hay un error retornando la lista de detalles
	 */
	@Path("list")
	@Produces(MediaType.APPLICATION_XML)
	@GET
	public List<DetalleOrdenCompra> obtener() throws RemoteException{
		List<DetalleOrdenCompra> detalles = new ArrayList<DetalleOrdenCompra>();
		List<DetalleOrdenCompra> listaDetalles = null;
		
		try{
			listaDetalles = detalleOrdenCompraService.obtenerLista();
				for(DetalleOrdenCompra detalleOrdenCompra: listaDetalles){
					DetalleOrdenCompra detalleWS = new DetalleOrdenCompra();
					
					detalleWS.setNumero(detalleOrdenCompra.getNumero());
					detalleWS.setNumOrdenCompra(detalleOrdenCompra.getNumOrdenCompra());
					detalleWS.setRefServicio(detalleOrdenCompra.getRefServicio());
					detalleWS.setCantidad(detalleOrdenCompra.getCantidad());
					detalleWS.setValor(detalleOrdenCompra.getValor());
					detalleWS.setObservaciones(detalleOrdenCompra.getObservaciones());
					
					detalles.add(detalleWS);
				}
			}catch(MyException e){
				throw new RemoteException(e.getMessage());
			}

		return detalles;
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
	@Produces(MediaType.TEXT_PLAIN)
	@POST
	public String ingresarDetalle(@QueryParam("numero")String numero, @QueryParam("numOrdenCompra")String numOrdenCompra,
			@QueryParam("refServicio")String refServicio, @QueryParam("cantidad")String cantidad, 
			@QueryParam("valor")String valor, @QueryParam("observaciones")String observaciones) throws RemoteException{
		try{
			detalleOrdenCompraService.insertarDetalleOrdenCompra(numero, numOrdenCompra, refServicio, cantidad, valor, observaciones);
			return "Detalle guardado correctamente";
		}catch(MyException e){
			return e.getMessage();
		}
	}
	
	/**
	 * Metodo para actualizar un detalle
	 * @param numero numero de detalle
	 * @param numOrdenCompra numero de orden de compra
	 * @param refServicio referencia de servicio
	 * @param cantidad cantidad
	 * @param valor valor
	 * @param observaciones observaciones
	 * @return mensaje de confirmacion
	 * @throws RemoteException cuando hay un error actualizando un detalle
	 */
	@Path("update")
	@Produces(MediaType.TEXT_PLAIN)
	@PUT
	public String actualizarDetalle(@QueryParam("numero")String numero, @QueryParam("numOrdenCompra")String numOrdenCompra,
			@QueryParam("refServicio")String refServicio, @QueryParam("cantidad")String cantidad, 
			@QueryParam("valor")String valor, @QueryParam("observaciones")String observaciones) throws RemoteException{
		try{
			detalleOrdenCompraService.modificarDetalleOrdenCompra(numero, numOrdenCompra, refServicio, cantidad, valor, observaciones);
			
			
		}catch(MyException e){
			return e.getMessage();
		}
		
		return "";
	}
	
	/**
	 * Metodo que permite eliminar un detalle
	 * @param numero numero de detalle
	 * @return mensaje de confirmacion
	 * @throws RemoteException cuando hay un error eliminando un detalle
	 */
	@Path("delete")
	@Produces(MediaType.TEXT_PLAIN)
	@DELETE
	public String eliminarDetalle(@QueryParam("numero")String numero) throws RemoteException{
		try{
			detalleOrdenCompraService.eliminarDetalleOrdenCompra(numero);
		}catch(MyException e){
			return e.getMessage();
		}
		
		return "";
	}
	
	
	
}
