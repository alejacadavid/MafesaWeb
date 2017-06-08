package co.mafesa.bl.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import co.mafesa.bl.OrdenCompraBL;
import co.mafesa.dao.ClienteDAO;
import co.mafesa.dao.EstadoDAO;
import co.mafesa.dao.EstadoOCDAO;
import co.mafesa.dao.OrdenCompraDAO;
import co.mafesa.dao.UsuarioDAO;
import co.mafesa.dto.Cliente;
import co.mafesa.dto.OrdenCompra;
import co.mafesa.dto.Usuario;
import co.mafesa.exception.MyException;

public class OrdenCompraBLImpl implements OrdenCompraBL {

	private OrdenCompraDAO ordenCompraDAO;
	private ClienteDAO clienteDAO;
	private UsuarioDAO usuarioDAO;
	private EstadoOCDAO estadoOCDAO;
	private EstadoDAO estadoDAO;
	
	
	public EstadoOCDAO getEstadoOCDAO() {
		return estadoOCDAO;
	}

	public void setEstadoOCDAO(EstadoOCDAO estadoOCDAO) {
		this.estadoOCDAO = estadoOCDAO;
	}

	public EstadoDAO getEstadoDAO() {
		return estadoDAO;
	}

	public void setEstadoDAO(EstadoDAO estadoDAO) {
		this.estadoDAO = estadoDAO;
	}

	public UsuarioDAO getUsuarioEstadoDAO() {
		return usuarioDAO;
	}

	
	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}

	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}
	
	

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	
	
	public OrdenCompraDAO getOrdenCompraDAO() {
		return ordenCompraDAO;
	}

	public void setOrdenCompraDAO(OrdenCompraDAO ordenCompraDAO) {
		this.ordenCompraDAO = ordenCompraDAO;
	}

	@Override
	public List<OrdenCompra> obtenerLista() throws MyException {
		return ordenCompraDAO.get();
	}

	
	@Override
	public void registrarOrdenCompra(String numOrdenCompra, String cliente,
			String formaPago, String plazoEntrega, String fechaEntrega,
			String direccionEntrega, String valorTotal, String usuarioCrea)
			throws MyException, ParseException {
		OrdenCompra ordenCompra = null;
		Cliente clienteL = null;
		Usuario usuario = null;
		
		if(numOrdenCompra == null || numOrdenCompra.isEmpty()){
			throw new MyException("El número de orden de compra no puede ser vacío");
		}
		if(cliente == null || cliente.isEmpty()){
			throw new MyException("El cliente no puede ser vacio");
		}
		if(formaPago == null || formaPago.isEmpty()){
			throw new MyException("La forma de pago no pueden ser vacia");
		}
		if(plazoEntrega == null || plazoEntrega.isEmpty()){
			throw new MyException("El plazo de entrega no puede ser vacio");
		}
		if(fechaEntrega == null || fechaEntrega.isEmpty()){
			throw new MyException("La fecha de entrega no puede ser vacia");
		}
		if(direccionEntrega == null || direccionEntrega.isEmpty()){
			throw new MyException("La direccion de entrega no puede ser vacia");
		}

		if(ordenCompraDAO.get(Integer.parseInt(numOrdenCompra))!= null){
			throw new MyException("Ya existe una orden de compra con este número en el sistema");
		}
		
		clienteL = clienteDAO.get(cliente);
		
		if(clienteL == null){
			throw new MyException("El cliente a asociar no existe en el sistema");
		}
		usuario = usuarioDAO.get(usuarioCrea);
		
		if(usuario == null){
			throw new MyException("El usuario que crea no existe en el sistema");
		}
		ordenCompra = new OrdenCompra();
		ordenCompra.setNumero(Integer.parseInt(numOrdenCompra));
		ordenCompra.setCliente(clienteL);
		ordenCompra.setFormaPago(formaPago);
		ordenCompra.setPlazoEntrega(Integer.parseInt(plazoEntrega));
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		ordenCompra.setFechaEntrega(sdf.parse(fechaEntrega));
		ordenCompra.setDireccionEntrega(direccionEntrega);
		ordenCompra.setValorTotal(Double.parseDouble(valorTotal));
		ordenCompra.setUsuarioCrea(usuario);
		ordenCompra.setFechaCreacion(new Date());
		
		ordenCompraDAO.insert(ordenCompra);

	}

	@Override
	public void eliminarOrdenCompra(String numOrdenCompra, String usuarioElimina) throws MyException {
		OrdenCompra ordenCompra = null;
		Usuario usuarioE = null;
		
		if(numOrdenCompra == null || numOrdenCompra.isEmpty()){
			throw new MyException("El número de la orden de compra no puede ser vacío");
		}
		
		ordenCompra = ordenCompraDAO.get(Integer.parseInt(numOrdenCompra));
		
		if(ordenCompra==null){
			throw new MyException("El cliente a eliminar no existe en el sistema");
		}

		usuarioE = usuarioDAO.get(usuarioElimina);
		
		if(usuarioE == null){
			throw new MyException("El usuario que elimina no existe en el sistema");
		}
		
		ordenCompra.setEliminado(Boolean.TRUE);
		ordenCompra.setFechaElimina(new Date());
		ordenCompraDAO.delete(ordenCompra);
		

	}

	@Override
	public void modificarOrdenCompra(String numOrdenCompra, String cliente,
			String formaPago, String plazoEntrega, String fechaEntrega,
			String direccionEntrega, String valorTotal, String usuarioModifica)
			throws MyException, ParseException {
		OrdenCompra ordenCompra = null;
		Cliente clienteL = null;
		Usuario usuario = null;
		
		if(numOrdenCompra == null || numOrdenCompra.isEmpty()){
			throw new MyException("El número de orden de compra no puede ser vacío");
		}
		if(cliente == null || cliente.isEmpty()){
			throw new MyException("El cliente no puede ser vacio");
		}
		if(formaPago == null || formaPago.isEmpty()){
			throw new MyException("La forma de pago no pueden ser vacia");
		}
		if(plazoEntrega == null || plazoEntrega.isEmpty()){
			throw new MyException("El plazo de entrega no puede ser vacio");
		}
		if(fechaEntrega == null || fechaEntrega.isEmpty()){
			throw new MyException("La fecha de entrega no puede ser vacia");
		}
		if(direccionEntrega == null || direccionEntrega.isEmpty()){
			throw new MyException("La direccion de entrega no puede ser vacia");
		}

		clienteL = clienteDAO.get(cliente);
		
		if(clienteL == null){
			throw new MyException("El cliente a asociar no existe en el sistema");
		}
		usuario = usuarioDAO.get(usuarioModifica);
		
		if(usuario == null){
			throw new MyException("El usuario que modifica no existe en el sistema");
		}
		ordenCompra = ordenCompraDAO.get(Integer.parseInt(numOrdenCompra));
		
		if(ordenCompra==null){
			throw new MyException("La orden de compra a modificar no existe en el sistema");
		}
		ordenCompra.setCliente(clienteL);
		ordenCompra.setFormaPago(formaPago);
		ordenCompra.setPlazoEntrega(Integer.parseInt(plazoEntrega));
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		ordenCompra.setFechaEntrega(sdf.parse(fechaEntrega));
		ordenCompra.setDireccionEntrega(direccionEntrega);
		ordenCompra.setValorTotal(Double.parseDouble(valorTotal));
		ordenCompra.setUsuarioModifica(usuario);
		ordenCompra.setFechaModifica(new Date());
		
		ordenCompraDAO.update(ordenCompra);

	}

	@Override
	public OrdenCompra buscarOrdenCompra(String numOrdenCompra) throws MyException {
	
		return ordenCompraDAO.get(Integer.parseInt(numOrdenCompra));
	}



}
