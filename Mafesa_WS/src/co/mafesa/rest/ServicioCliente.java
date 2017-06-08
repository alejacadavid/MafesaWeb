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

import co.mafesa.bl.ClienteBL;
import co.mafesa.dto.Cliente;
import co.mafesa.exception.MyException;

/**
 * Implementacion de los servicios web de la logica de negocio para los clientes
 * @author Maria Alejandra Cadavid Osorio - mariaa.cadavid@udea.edu.co
 *
 */
@Path("Cliente")
@Component
public class ServicioCliente {
	
	@Autowired
	private ClienteBL clienteService;
	
	/**
	 * Metodo para retornar todos los clientes
	 * @return lista de clientes
	 * @throws RemoteException cuando hay un error retornando la lista de clientes
	 */
	@Path("list")
	@Produces(MediaType.APPLICATION_XML)
	@GET
	public List<Cliente> obtener() throws RemoteException{
		List<Cliente> clientes = new ArrayList<Cliente>();
		List<Cliente> listaClientes = null;
		
		try{
			listaClientes = clienteService.obtenerLista();
				for(Cliente cliente: listaClientes){
					Cliente clienteWS = new Cliente();
					
					clienteWS.setCodigoCliente(cliente.getCodigoCliente());
					clienteWS.setTipoId(cliente.getTipoId());
					clienteWS.setId(cliente.getId());
					clienteWS.setRazonSocial(cliente.getRazonSocial());
					clienteWS.setDireccion(cliente.getDireccion());
					clienteWS.setTelefono(cliente.getTelefono());
					clienteWS.setEmail(cliente.getEmail());
					clientes.add(clienteWS);
				}
			}catch(MyException e){
				throw new RemoteException(e.getMessage());
			}

		return clientes;
	}
	
	/**
	 * Metodo que permite guardar clientes
	 * @param codigoCliente codigo del cliente
	 * @param tipoId tipo de identificacion
	 * @param numeroIdentificacion numero de identificacion
	 * @param razonSocial razon social
	 * @param direccion direccion
	 * @param telefono telefono
	 * @param email email
	 * @return Mensaje de confirmacion de operacion
	 * @throws RemoteException cuando hay un error guardarndo el cliente
	 */
	@Produces(MediaType.TEXT_PLAIN)
	@POST
	public String guardarCliente(@QueryParam("codigoCliente")String codigoCliente, @QueryParam("tipoId")String tipoId,
			@QueryParam("numeroIdentificacion")String numeroIdentificacion, @QueryParam("razonSocial")String razonSocial, 
			@QueryParam("direccion")String direccion, @QueryParam("telefono")String telefono, @QueryParam("email")String email) throws RemoteException{
		try{
			clienteService.guardarCliente(codigoCliente, tipoId, numeroIdentificacion, razonSocial, direccion, telefono, email);
			return "Cliente guardado correctamente";
		}catch(MyException e){
			return e.getMessage();
		}
		
		
	}
	/**
	 * Metodo que permite actualizar un cliente
	 * @param codigoCliente codigo del cliente
	 * @param tipoId tipo de identificacion
	 * @param numeroIdentificacion numero de identificacion
	 * @param razonSocial razon social
	 * @param direccion direccion
	 * @param telefono telefono
	 * @param email email
	 * @return mensaje de confirmacion de la operacion
	 * @throws RemoteException cuando hay un error modificando el cliente
	 */
	@Path("update")
	@Produces(MediaType.TEXT_PLAIN)
	@PUT
	public String actualizarCliente(@QueryParam("codigoCliente")String codigoCliente, @QueryParam("tipoId")String tipoId,
			@QueryParam("numeroIdentificacion")String numeroIdentificacion, @QueryParam("razonSocial")String razonSocial, 
			@QueryParam("direccion")String direccion, @QueryParam("telefono")String telefono, @QueryParam("email")String email) throws RemoteException{
		try{
			clienteService.actualizarCliente(codigoCliente, tipoId, numeroIdentificacion, razonSocial, direccion, telefono, email);
			
		}catch(MyException e){
			return e.getMessage();
		}
		
		return "";
	}
	
	/**
	 * Metodo que permite eliminar un cliente
	 * @param codigoCliente codigo del cliente
	 * @return mensaje de confirmacion de la operacion
	 * @throws RemoteException cuando hay un error eliminando el cliente
	 */
	@Path("delete")
	@Produces(MediaType.TEXT_PLAIN)
	@DELETE
	public String eliminarCliente(@QueryParam("codigoCliente")String codigoCliente) throws RemoteException{
		try{
			clienteService.eliminarCliente(codigoCliente);
		}catch(MyException e){
			return e.getMessage();
		}
		
		return "";
	}
	
	/**
	 * Busca un cliente por su codigo
	 * @param codigoCliente codigo del cliente
	 * @return Cliente
	 * @throws RemoteException cuando hay un error buscando el cliente
	 */
	@Path("search")
	@Produces(MediaType.APPLICATION_XML)
	@GET
	public Cliente buscarCliente(@QueryParam("codigoCliente")String codigoCliente) throws RemoteException{
		Cliente cliente = new Cliente();
		try{
			cliente = clienteService.buscarCliente(codigoCliente);
		}catch(MyException e){
			throw new RemoteException(e.getMessage());
		}
		
		return cliente;
	}
	
	
}
