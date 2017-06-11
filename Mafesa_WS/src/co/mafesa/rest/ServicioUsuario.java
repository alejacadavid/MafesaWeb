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

import co.mafesa.bl.UsuarioBL;
import co.mafesa.dto.Usuario;
import co.mafesa.exception.MyException;

/**
 * Implementacion de los servicios web de la logica de negocio para el usuario
 * @author Maria Alejandra Cadavid Osorio - mariaa.cadavid@udea.edu.co
 *
 */
@Path("Usuario")
@Component
public class ServicioUsuario {

	@Autowired
	private UsuarioBL usuarioService;
	
	/**
	 * Metodo que retorna una lista de usuarios
	 * @return lista de usuarios
	 * @throws RemoteException cuando hay un error retornando una lista de usuarios
	 */
	@Path("list")
	@Produces(MediaType.APPLICATION_XML)
	@GET
	public List<Usuario> obtener() throws RemoteException{
		List<Usuario> usuarios = new ArrayList<Usuario>();
		List<Usuario> listaUsuarios = null;
		
		try{
			listaUsuarios = usuarioService.obtenerLista();
				for(Usuario usuario: listaUsuarios){
					Usuario usuarioWS = new Usuario();
					
					usuarioWS.setNombreUsuario(usuario.getNombreUsuario());
					usuarioWS.setTipoId(usuario.getTipoId());
					usuarioWS.setNumeroId(usuario.getNumeroId());
					usuarioWS.setNombres(usuario.getNombres());
					usuarioWS.setApellidos(usuario.getApellidos());
					usuarioWS.setDireccion(usuario.getDireccion());
					usuarioWS.setTelefono(usuario.getTelefono());
					usuarioWS.setEmail(usuario.getEmail());
					usuarioWS.setContraseña(usuario.getContraseña());
					usuarioWS.setFechaCreacion(usuario.getFechaCreacion());
					usuarioWS.setCliente(usuario.getCliente());

					usuarios.add(usuarioWS);
				}
			}catch(MyException e){
				throw new RemoteException(e.getMessage());
			}

		return usuarios;
	}
	
	/**
	 * Metodo que permite la informacion de un usuario
	 * @param nombreUsuario nombre de usuario
	 * @param tipoId tipo de identificacion
	 * @param numeroIdentificacion numero de identificacion
	 * @param nombres nombres
	 * @param apellidos apellidos
	 * @param direccion direccion
	 * @param telefono telefono
	 * @param email email
	 * @param contrasena contraseña
	 * @param cliente cliente
	 * @return mensaje de confirmacion
	 * @throws RemoteException cuando un error guardando un usuario
	 */
	@Produces(MediaType.TEXT_PLAIN)
	@POST
	public String guardarUsuario(@QueryParam("nombreUsuario")String nombreUsuario, @QueryParam("tipoId")String tipoId,
			@QueryParam("numeroIdentificacion")String numeroIdentificacion, @QueryParam("nombres")String nombres, 
			@QueryParam("apellidos")String apellidos, @QueryParam("direccion")String direccion, @QueryParam("telefono")String telefono,
			@QueryParam("email")String email, @QueryParam("contrasena")String contrasena, @QueryParam("cliente")String cliente) 
					throws RemoteException{
		try{
			usuarioService.registrarUsuario(nombreUsuario, tipoId, numeroIdentificacion, nombres, apellidos, direccion, telefono, email, contrasena, cliente);

			return "Usuario guardado correctamente";
		}catch(MyException e){
			return e.getMessage();
		}
		
		
	}
	
	/**
	 * Metodo que permite actualziar un usuario
	 * @param nombreUsuario nombre de usuario
	 * @param tipoId tipo de identificacion
	 * @param numeroIdentificacion numero de identificacion
	 * @param nombres nombres
	 * @param apellidos apellidos
	 * @param direccion direccion
	 * @param telefono telefono
	 * @param email email
	 * @param contrasena contraseña
	 * @param cliente cliente
	 * @return mensaje de confirmacion
	 * @throws RemoteException cuando un error actualizando un usuario
	 */
	@Path("update")
	@Produces(MediaType.TEXT_PLAIN)
	@PUT
	public String actualizarUsuario(@QueryParam("nombreUsuario")String nombreUsuario, @QueryParam("tipoId")String tipoId,
			@QueryParam("numeroIdentificacion")String numeroIdentificacion, @QueryParam("nombres")String nombres, 
			@QueryParam("apellidos")String apellidos, @QueryParam("direccion")String direccion, @QueryParam("telefono")String telefono,
			@QueryParam("email")String email, @QueryParam("contrasena")String contrasena, @QueryParam("cliente")String cliente) 
					throws RemoteException{
		try{
			usuarioService.actualizarUsuario(nombreUsuario, tipoId, numeroIdentificacion, nombres, apellidos, direccion, telefono, email, contrasena, cliente);
			
		}catch(MyException e){
			return e.getMessage();
		}
		
		return "";
	}
	
	/**
	 * Metodo para eliminar un usuario
	 * @param nombreUsuario nombre de usuario
	 * @return mensaje de confirmacion
	 * @throws RemoteException cuando hay un error eliminando un usuario
	 */
	@Path("delete")
	@Produces(MediaType.TEXT_PLAIN)
	@DELETE
	public String eliminarCliente(@QueryParam("nombreUsuario")String nombreUsuario) throws RemoteException{
		try{
			usuarioService.eliminarUsuario(nombreUsuario);
		}catch(MyException e){
			return e.getMessage();
		}
		
		return "";
	}
	
	/**
	 * Metodo que permite autenticar un usuario
	 * @param login nombre de usuario
	 * @param contrasena contraseña
	 * @return mensaje de confirmacion
	 */
	@Path("login")
	@Produces(MediaType.TEXT_PLAIN)
	@GET
	public String validar(@QueryParam("login")String login, @QueryParam("pws")String pws){
		try{
			usuarioService.autenticar(login, pws);
		}catch(MyException e){
			return e.getMessage();
		}
		return "";
	}
}
