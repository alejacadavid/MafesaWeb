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

import co.mafesa.bl.EstadoOCBL;
import co.mafesa.dto.EstadoOC;
import co.mafesa.exception.MyException;

/**
 * Implementacion de los servicios web de la logica de negocio para los estados de una orden de compra
 * @author Maria Alejandra Cadavid Osorio - mariaa.cadavid@udea.edu.co
 *
 */
@Path("EstadoOrdenCompra")
@Component
public class ServicioEstadoOC {
	
	@Autowired
	private EstadoOCBL estadoOCService;
	
	/**
	 * Lista los estados de las ordenes de compra
	 * @return lista de estados
	 * @throws RemoteException cuando hay un error retornando los estados
	 */
	@Path("list")
	@Produces(MediaType.APPLICATION_XML)
	@GET
	public List<EstadoOC> obtener() throws RemoteException{
		List<EstadoOC> estados = new ArrayList<EstadoOC>();
		List<EstadoOC> listaEstados = null;
		
		try{
			listaEstados = estadoOCService.obtenerLista();
				for(EstadoOC estadoOC: listaEstados){
					EstadoOC estadoOCWS = new EstadoOC();
					
					estadoOCWS.setNumero(estadoOC.getNumero());
					estadoOCWS.setEstado(estadoOC.getEstado());
					estadoOCWS.setUsuarioEstado(estadoOC.getUsuarioEstado());
					estadoOCWS.setCantidadPendiente(estadoOC.getCantidadPendiente());
					estadoOCWS.setCantidadProcesada(estadoOC.getCantidadProcesada());
					estadoOCWS.setFechaEstado(estadoOC.getFechaEstado());
					estadoOCWS.setIdOrdenCompra(estadoOC.getIdOrdenCompra());
					
					estados.add(estadoOCWS);
				}
			}catch(MyException e){
				throw new RemoteException(e.getMessage());
			}

		return estados;
	}
	
	/**
	 * Metodo que permite ingresar el estado de una orden de compra
	 * @param numero numero de estado
	 * @param estado estado
	 * @param usuarioEstado usuario
	 * @param cantidadPendiente cantidad pendiente
	 * @param cantidadProcesada cantidad procesada
	 * @param ordenCompra orden de compra
	 * @return mensaje de confirmacion
	 * @throws RemoteException cuando hay un error ingresando el estado de una orden de compra
	 */
	@Produces(MediaType.TEXT_PLAIN)
	@POST
	public String ingresarEstado(@QueryParam("numero")String numero, @QueryParam("estado")String estado,
			@QueryParam("usuarioEstado")String usuarioEstado, @QueryParam("cantidadPendiente")String cantidadPendiente, 
			@QueryParam("cantidadProcesada")String cantidadProcesada, @QueryParam("ordenCompra")String ordenCompra) throws RemoteException{
		try{
			estadoOCService.insertarEstadoOC(numero, estado, usuarioEstado, cantidadPendiente, cantidadProcesada, ordenCompra);
			
		}catch(MyException e){
			return e.getMessage();
		}
		
		return "";
	}
	
	/**
	 * Metodo que permite actualizar el etado de una orden de compra
	 * @param numero numero de estado
	 * @param estado estado
	 * @param usuarioEstado usuario
	 * @param cantidadPendiente cantidad pendiente
	 * @param cantidadProcesada cantidad procesada
	 * @param ordenCompra orden de compra
	 * @return mensaje de confirmacion
	 * @throws RemoteException cuando hay un error actualizando el estado de una orden de compra
	 */
	@Path("update")
	@Produces(MediaType.TEXT_PLAIN)
	@PUT
	public String actualizarEstado(@QueryParam("numero")String numero, @QueryParam("estado")String estado,
			@QueryParam("usuarioEstado")String usuarioEstado, @QueryParam("cantidadPendiente")String cantidadPendiente, 
			@QueryParam("cantidadProcesada")String cantidadProcesada, @QueryParam("ordenCompra")String ordenCompra) throws RemoteException{
		try{
			estadoOCService.modificarEstadoOC(numero, estado, usuarioEstado, cantidadPendiente, cantidadProcesada, ordenCompra);
		}catch(MyException e){
			return e.getMessage();
		}
		
		return "";
	}
	
	/**
	 * Metodo que permite eliminar el estado de una orden de compra
	 * @param numero numero de estado
	 * @return mensaje de confirmacion
	 * @throws RemoteException cuando hay un error eliminando el estado de una orden de compra
	 */
	@Path("delete")
	@Produces(MediaType.TEXT_PLAIN)
	@DELETE
	public String eliminarEstado(@QueryParam("numero")String numero) throws RemoteException{
		try{
			estadoOCService.eliminarEstadoOC(numero);
		}catch(MyException e){
			return e.getMessage();
		}
		
		return "";
	}
	
	
	
}
