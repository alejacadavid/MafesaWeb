package co.mafesa.bl.impl;

import java.util.Date;
import java.util.List;

import co.mafesa.bl.EstadoOCBL;
import co.mafesa.dao.EstadoDAO;
import co.mafesa.dao.EstadoOCDAO;
import co.mafesa.dao.OrdenCompraDAO;
import co.mafesa.dao.UsuarioDAO;
import co.mafesa.dto.Estado;
import co.mafesa.dto.EstadoOC;
import co.mafesa.dto.OrdenCompra;
import co.mafesa.dto.Usuario;
import co.mafesa.exception.MyException;

public class EstadoOCBLImpl implements EstadoOCBL {

	private EstadoOCDAO estadoOCDAO;
	private EstadoDAO estadoDAO;
	private UsuarioDAO usuarioDAO;
	private OrdenCompraDAO ordenCompraDAO;
	
	
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
	public List<EstadoOC> obtenerLista() throws MyException {
		return estadoOCDAO.get();
	}

	@Override
	public void insertarEstadoOC(String numero, String estado, String usuario,
			String cantidadPendiente, String cantidadProcesada,
			String ordenCompra) throws MyException {
		EstadoOC estadoOC = null;
		Usuario usuarioEstado = null;
		Estado estadoL = null;
		OrdenCompra ordenCompraL = null;
		
		if(numero == null || numero.isEmpty()){
			throw new MyException("El numero del estado no puede ser vacía");
		}
		if(estado == null || estado.isEmpty()){
			throw new MyException("El estado no puede ser vacio");
		}
		if(usuario == null || usuario.isEmpty()){
			throw new MyException("El usuario no pueden ser vacio");
		}
		if(cantidadPendiente == null || cantidadPendiente.isEmpty()){
			throw new MyException("La cantidad pendiente no puede ser vacia");
		}
		if(cantidadProcesada == null || cantidadProcesada.isEmpty()){
			throw new MyException("La cantidad procesada no puede ser vacia");
		}
		if(ordenCompra == null || ordenCompra.isEmpty()){
			throw new MyException("La orden de compra no puede ser vacio");
		}

		if(estadoOCDAO.get(Integer.parseInt(numero)) != null){
			throw new MyException("Ya existe un estado con este numero en el sistema");
		}
		
		estadoOC = new EstadoOC();
		estadoOC.setNumero(Integer.parseInt(numero));
		
		estadoL = estadoDAO.get(Integer.parseInt(estado));
		
		if(estadoL == null){
			throw new MyException("El estado a asociar no existe en el sistema");
		}
		
		estadoOC.setEstado(estadoL);
		usuarioEstado = usuarioDAO.get(usuario);
		if(usuarioEstado == null){
			throw new MyException("El usuario a asociar no existe en el sistema");
		}
		estadoOC.setUsuarioEstado(usuarioEstado);
		estadoOC.setCantidadPendiente(Integer.parseInt(cantidadPendiente));
		estadoOC.setCantidadProcesada(Integer.parseInt(cantidadProcesada));
		estadoOC.setFechaEstado(new Date());
		ordenCompraL = ordenCompraDAO.get(Integer.parseInt(ordenCompra));
		
		if(ordenCompraL == null){
			throw new MyException("La orden de compra a asociar no existe en el sistema");
		}
		
		estadoOC.setIdOrdenCompra(ordenCompraL);
		
		estadoOCDAO.insert(estadoOC);

	}

	@Override
	public void eliminarEstadoOC(String numero) throws MyException {
		EstadoOC estadoOC = null;
		
		if(numero == null || numero.isEmpty()){
			throw new MyException("El número del estado no puede ser vacío");
		}
		estadoOC = estadoOCDAO.get(Integer.parseInt(numero));
		if(estadoOC==null){
			throw new MyException("El estado a eliminar no existe en el sistema");
		}
		estadoOCDAO.delete(estadoOC);

	}

	@Override
	public void modificarEstadoOC(String numero, String estado, String usuario,
			String cantidadPendiente, String cantidadProcesada,
			String ordenCompra) throws MyException {
		EstadoOC estadoOC = null;
		Usuario usuarioEstado = null;
		Estado estadoL = null;
		OrdenCompra ordenCompraL = null;
		
		if(numero == null || numero.isEmpty()){
			throw new MyException("El numero del estado no puede ser vacía");
		}
		if(estado == null || estado.isEmpty()){
			throw new MyException("El estado no puede ser vacio");
		}
		if(usuario == null || usuario.isEmpty()){
			throw new MyException("El usuario no pueden ser vacio");
		}
		if(cantidadPendiente == null || cantidadPendiente.isEmpty()){
			throw new MyException("La cantidad pendiente no puede ser vacia");
		}
		if(cantidadProcesada == null || cantidadProcesada.isEmpty()){
			throw new MyException("La cantidad procesada no puede ser vacia");
		}
		if(ordenCompra == null || ordenCompra.isEmpty()){
			throw new MyException("La orden de compra no puede ser vacio");
		}

		estadoOC = estadoOCDAO.get(Integer.parseInt(numero));
		
		if(estadoOC==null){
			throw new MyException("El estado a modificar no existe en el sistema");
		}
		
		estadoL = estadoDAO.get(Integer.parseInt(estado));
		
		if(estadoL == null){
			throw new MyException("El estado a asociar no existe en el sistema");
		}
		
		estadoOC.setEstado(estadoL);
		usuarioEstado = usuarioDAO.get(usuario);
		if(usuarioEstado == null){
			throw new MyException("El usuario a asociar no existe en el sistema");
		}
		estadoOC.setUsuarioEstado(usuarioEstado);
		estadoOC.setCantidadPendiente(Integer.parseInt(cantidadPendiente));
		estadoOC.setCantidadProcesada(Integer.parseInt(cantidadProcesada));
		estadoOC.setFechaEstado(new Date());
		ordenCompraL = ordenCompraDAO.get(Integer.parseInt(ordenCompra));
		
		if(ordenCompraL == null){
			throw new MyException("La orden de compra a asociar no existe en el sistema");
		}
		
		estadoOC.setIdOrdenCompra(ordenCompraL);
		
		estadoOCDAO.update(estadoOC);

	}

}
