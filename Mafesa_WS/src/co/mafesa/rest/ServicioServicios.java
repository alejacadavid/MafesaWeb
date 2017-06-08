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

import co.mafesa.bl.ServicioBL;
import co.mafesa.dto.Servicio;
import co.mafesa.exception.MyException;

/**
 * Implementacion de los servicios web de la logica de negocio para el servicio
 * @author Maria Alejandra Cadavid Osorio - mariaa.cadavid@udea.edu.co
 *
 */
@Path("Servicio")
@Component
public class ServicioServicios {

	@Autowired
	private ServicioBL servicioService;
	
	/**
	 * Metodo que retorna la lista de servicios
	 * @return lista de servicios
	 * @throws RemoteException cuando hay un error retornando la lista de servicios
	 */
	@Path("list")
	@Produces(MediaType.APPLICATION_XML)
	@GET
	public List<Servicio> obtener() throws RemoteException{
		List<Servicio> servicios = new ArrayList<Servicio>();
		List<Servicio> listaServicios = null;
		
		try{
			listaServicios = servicioService.obtenerLista();
				for(Servicio servicio: listaServicios){
					Servicio servicioWS = new Servicio();
					
					servicioWS.setRefServicio(servicio.getRefServicio());
					servicioWS.setDescripcion(servicio.getDescripcion());
					servicioWS.setPrecioUnitario(servicio.getPrecioUnitario());

					servicios.add(servicioWS);
				}
			}catch(MyException e){
				throw new RemoteException(e.getMessage());
			}

		return servicios;
	}
	
	/**
	 * Metodo que permite guardar un servicio
	 * @param refServicio referencia de servicio
	 * @param descripcion descripcion
	 * @param precioUnitario precio unitario
	 * @return mensaje de confirmacion
	 * @throws RemoteException caundo hay un error guardando un servicio
	 */
	@Produces(MediaType.TEXT_PLAIN)
	@POST
	public String guardarServicio(@QueryParam("refServicio")String refServicio, @QueryParam("descripcion")String descripcion,
			@QueryParam("precioUnitario")String precioUnitario) throws RemoteException{
		try{
			servicioService.registrarServicio(refServicio, descripcion, Double.parseDouble(precioUnitario));

			return "Servicio guardado correctamente";
		}catch(MyException e){
			return e.getMessage();
		}
		
		
	}
	
	/**
	 * Metodo que permite actualizar un servicio
	 * @param refServicio referencia de servicio
	 * @param descripcion descripcion
	 * @param precioUnitario precio unitario
	 * @return mensaje de confirmacion
	 * @throws RemoteException caundo hay un error actualizando un servicio
	 */
	@Path("update")
	@Produces(MediaType.TEXT_PLAIN)
	@PUT
	public String actualizarServicio(@QueryParam("refServicio")String refServicio, @QueryParam("descripcion")String descripcion,
			@QueryParam("precioUnitario")String precioUnitario) throws RemoteException{
		try{
			servicioService.actualizarServicio(refServicio, descripcion, Double.parseDouble(precioUnitario));
			
		}catch(MyException e){
			return e.getMessage();
		}
		
		return "";
	}
	
	/**
	 * Metodo que permite eliminar un servicio
	 * @param refServicio referencia de servicio
	 * @return mensaje de confirmacion
	 * @throws RemoteException cuando hay un error eliminando un servicio
	 */
	@Path("delete")
	@Produces(MediaType.TEXT_PLAIN)
	@DELETE
	public String eliminarServicio(@QueryParam("refServicio")String refServicio) throws RemoteException{
		try{
			servicioService.eliminarServicio(refServicio);
		}catch(MyException e){
			return e.getMessage();
		}
		
		return "";
	}
	
}
