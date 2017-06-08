package co.mafesa.bl.impl;

import java.util.List;

import co.mafesa.bl.ClienteBL;
import co.mafesa.dao.ClienteDAO;
import co.mafesa.dto.Cliente;
import co.mafesa.exception.MyException;
import co.mafesa.util.Validaciones;

public class ClienteBLImpl implements ClienteBL {
	
	private ClienteDAO clienteDAO;
	
	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}

	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	@Override
	public List<Cliente> obtenerLista() throws MyException {
		return clienteDAO.get();
	}

	@Override
	public void guardarCliente(String codigoCliente, String tipoId, String numeroIdentificacion, 
			String razonSocial, String direccion, String telefono, String email) throws MyException {
		
		Cliente cliente = null;
		
		if(codigoCliente == null || codigoCliente.isEmpty()){
			throw new MyException("El codigo del cliente no puede ser vacía");
		}
		if(tipoId == null || tipoId.isEmpty()){
			throw new MyException("El tipo de identificacion del cliente no puede ser vacio");
		}
		if(numeroIdentificacion == null || numeroIdentificacion.isEmpty()){
			throw new MyException("El número de identificacion del cliente no pueden ser vacio");
		}
		if(razonSocial == null || razonSocial.isEmpty()){
			throw new MyException("La razon social del cliente no puede ser vacia");
		}
		if(direccion == null || direccion.isEmpty()){
			throw new MyException("La direccion del cliente no puede ser vacia");
		}
		if(telefono == null || telefono.isEmpty()){
			throw new MyException("El telefono del cliente no puede ser vacio");
		}
		if(email == null || email.isEmpty()){
			throw new MyException("El email del cliente no puede ser vacio");
		}
		if(!Validaciones.isEmail(email)){
			throw new MyException("El correo electrónico del cliente no es válido");
		}

		if(clienteDAO.get(codigoCliente) != null){
			throw new MyException("Ya existe un cliente con esta cedula en el sistema");
		}
		
		cliente = new Cliente();
		cliente.setCodigoCliente(codigoCliente);
		cliente.setTipoId(tipoId);
		cliente.setId(numeroIdentificacion);
		cliente.setRazonSocial(razonSocial);
		cliente.setDireccion(direccion);
		cliente.setTelefono(telefono);
		cliente.setEmail(email);
		
		clienteDAO.insert(cliente);
	}
	
	@Override
	public void actualizarCliente(String codigoCliente, String tipoId, String numeroIdentificacion, 
			String razonSocial, String direccion, String telefono, String email) throws MyException {
		
		Cliente cliente = null;
		
		if(codigoCliente == null || codigoCliente.isEmpty()){
			throw new MyException("El codigo del cliente no puede ser vacía");
		}
		if(tipoId == null || tipoId.isEmpty()){
			throw new MyException("El tipo de identificacion del cliente no puede ser vacio");
		}
		if(numeroIdentificacion == null || numeroIdentificacion.isEmpty()){
			throw new MyException("El número de identificacion del cliente no pueden ser vacio");
		}
		if(razonSocial == null || razonSocial.isEmpty()){
			throw new MyException("La razon social del cliente no puede ser vacia");
		}
		if(direccion == null || direccion.isEmpty()){
			throw new MyException("La direccion del cliente no puede ser vacia");
		}
		if(telefono == null || telefono.isEmpty()){
			throw new MyException("El telefono del cliente no puede ser vacio");
		}
		if(email == null || email.isEmpty()){
			throw new MyException("El email del cliente no puede ser vacio");
		}
		if(!Validaciones.isEmail(email)){
			throw new MyException("El correo electrónico del cliente no es válido");
		}


		cliente = clienteDAO.get(codigoCliente);
		
		if(cliente==null){
			throw new MyException("El cliente a modificar no existe en el sistema");
		}
		
		cliente.setTipoId(tipoId);
		cliente.setId(numeroIdentificacion);
		cliente.setRazonSocial(razonSocial);
		cliente.setDireccion(direccion);
		cliente.setTelefono(telefono);
		cliente.setEmail(email);
		
		clienteDAO.update(cliente);
	}
	
	@Override
	public void eliminarCliente(String codigoCliente) throws MyException {

		Cliente cliente = null;
		
		if(codigoCliente == null || codigoCliente.isEmpty()){
			throw new MyException("El codigo del cliente no puede ser vacío");
		}
		cliente = clienteDAO.get(codigoCliente);
		if(cliente==null){
			throw new MyException("El cliente a eliminar no existe en el sistema");
		}
		clienteDAO.delete(cliente);
		
		

	}

	@Override
	public Cliente buscarCliente(String codigoCliente) throws MyException {
		return clienteDAO.get(codigoCliente);
	}
	
	


}
