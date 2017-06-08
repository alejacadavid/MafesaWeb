package co.mafesa.bl.impl;

import java.util.Date;
import java.util.List;
import co.mafesa.bl.UsuarioBL;
import co.mafesa.dao.ClienteDAO;
import co.mafesa.dao.UsuarioDAO;
import co.mafesa.dto.Usuario;
import co.mafesa.exception.MyException;
import co.mafesa.util.Validaciones;

public class UsuarioBLImpl implements UsuarioBL {

	UsuarioDAO usuarioDAO;
	ClienteDAO clienteDAO;

	
	/**
	 * @return the clienteDAO
	 */
	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}

	/**
	 * @param clienteDAO the clienteDAO to set
	 */
	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	@Override
	public void autenticar(String nombreUsuario, String pws) throws MyException {
		Usuario usuario = null;
		String pwsCifrado = null;
		usuario = usuarioDAO.get(nombreUsuario);
		
		if(usuario == null){
			throw new MyException("Login o contraseña incorrecta");
		}
		
		//pwsCifrado = Cifrar.encrypt(pws);
		
		if(!usuario.getContraseña().equals(pws)){
			throw new MyException("Login o contraseña incorrecta");
		}
	}

	@Override
	public void registrarUsuario(String nombreUsuario, String tipoId, String numeroId, String nombres, String apellidos,
			String direccion, String telefono, String email, String contraseña, String cliente) throws MyException {
		
		Usuario usuario = null;

		if(nombreUsuario == null || nombreUsuario.isEmpty()){
			throw new MyException("El nombre de usuario no puede ser vacío");
		}
		if(tipoId == null || tipoId.isEmpty()){
			throw new MyException("El tipo de identificacion del usuario no puede ser vacio");
		}
		if(nombres == null || nombres.isEmpty()){
			throw new MyException("El nombre del usuario no puede ser vacio");
		}
		if(apellidos == null || apellidos.isEmpty()){
			throw new MyException("La razon social del usaurio no puede ser vacia");
		}
		if(direccion == null || direccion.isEmpty()){
			throw new MyException("La direccion del usuario no puede ser vacia");
		}
		if(telefono == null || telefono.isEmpty()){
			throw new MyException("El telefono del usuario no puede ser vacio");
		}
		if(email == null || email.isEmpty()){
			throw new MyException("El email del usuario no puede ser vacio");
		}
		if(!Validaciones.isEmail(email)){
			throw new MyException("El correo electrónico del usuario no es válido");
		}
		
		if(contraseña == null || contraseña.isEmpty()){
			throw new MyException("La contraseña del usuario no puede ser vacio");
		}

		


		if(usuarioDAO.get(nombreUsuario) != null){
			throw new MyException("Ya existe un usuario con este nombre de usuario en el sistema");
		}
		
		usuario = new Usuario();
		usuario.setNombreUsuario(nombreUsuario);
		usuario.setTipoId(tipoId);
		usuario.setNumeroId(numeroId);
		usuario.setNombres(nombres);
		usuario.setApellidos(apellidos);
		usuario.setDireccion(direccion);
		usuario.setTelefono(telefono);
		usuario.setEmail(email);
		usuario.setContraseña(contraseña);
		usuario.setFechaCreacion(new Date());
		if(cliente != null){
			if(clienteDAO.get(cliente) == null){
				throw new MyException("El cliente a asociar al usuario no existe en el sistema");
			}else{
				usuario.setCliente(clienteDAO.get(cliente));
			}
		}
		
		usuarioDAO.insert(usuario);
		
	}

	@Override
	public List<Usuario> obtenerLista() throws MyException {
		return usuarioDAO.get();
	}

	@Override
	public void eliminarUsuario(String nombreUsuario) throws MyException {
		Usuario usuario = null;
		
		if(nombreUsuario == null || nombreUsuario.isEmpty()){
			throw new MyException("El nombre del usuario no puede ser vacío");
		}
		usuario = usuarioDAO.get(nombreUsuario);
		if(usuario==null){
			throw new MyException("El usuario a eliminar no existe en el sistema");
		}
		usuarioDAO.delete(usuario);
		
	}

	@Override
	public void actualizarUsuario(String nombreUsuario, String tipoId,
			String numeroIdentificacion, String nombres, String apellidos,
			String direccion, String telefono, String email, String contraseña,
			String cliente) throws MyException {
		
		Usuario usuario = null;

		
		if(nombreUsuario == null || nombreUsuario.isEmpty()){
			throw new MyException("El nombre de usuario no puede ser vacío");
		}
		if(tipoId == null || tipoId.isEmpty()){
			throw new MyException("El tipo de identificacion del usuario no puede ser vacio");
		}
		if(nombres == null || nombres.isEmpty()){
			throw new MyException("El nombre del usuario no puede ser vacio");
		}
		if(apellidos == null || apellidos.isEmpty()){
			throw new MyException("La razon social del usaurio no puede ser vacia");
		}
		if(direccion == null || direccion.isEmpty()){
			throw new MyException("La direccion del usuario no puede ser vacia");
		}
		if(telefono == null || telefono.isEmpty()){
			throw new MyException("El telefono del usuario no puede ser vacio");
		}
		if(email == null || email.isEmpty()){
			throw new MyException("El email del usuario no puede ser vacio");
		}
		if(!Validaciones.isEmail(email)){
			throw new MyException("El correo electrónico del usuario no es válido");
		}
		
		if(contraseña == null || contraseña.isEmpty()){
			throw new MyException("La contraseña del usuario no puede ser vacio");
		}


		usuario = usuarioDAO.get(nombreUsuario);
		
		if(usuario==null){
			throw new MyException("El usuario a modificar no existe en el sistema");
		}
		
	
		usuario.setTipoId(tipoId);
		usuario.setNumeroId(numeroIdentificacion);
		usuario.setNombres(nombres);
		usuario.setApellidos(apellidos);
		usuario.setDireccion(direccion);
		usuario.setTelefono(telefono);
		usuario.setEmail(email);
		usuario.setContraseña(contraseña);
		usuario.setFechaCreacion(new Date());
	
		if(cliente != null){
			if(clienteDAO.get(cliente) == null){
				throw new MyException("El cliente a asociar al usuario no existe en el sistema");
			}else{
				usuario.setCliente(clienteDAO.get(cliente));
			}
		}
		usuarioDAO.update(usuario);
		
		
		
	}

	@Override
	public Usuario buscarUsuario(String nombreUsuario) throws MyException {
		return usuarioDAO.get(nombreUsuario);
	}
	
	
	
	

}
