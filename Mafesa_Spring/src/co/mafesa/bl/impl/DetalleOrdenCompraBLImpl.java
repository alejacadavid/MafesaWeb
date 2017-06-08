package co.mafesa.bl.impl;

import java.util.List;

import co.mafesa.bl.DetalleOrdenCompraBL;
import co.mafesa.dao.DetalleOrdenCompraDAO;
import co.mafesa.dao.OrdenCompraDAO;
import co.mafesa.dao.ServicioDAO;
import co.mafesa.dto.DetalleOrdenCompra;
import co.mafesa.dto.OrdenCompra;
import co.mafesa.dto.Servicio;
import co.mafesa.exception.MyException;

public class DetalleOrdenCompraBLImpl implements DetalleOrdenCompraBL {

	private DetalleOrdenCompraDAO detalleOrdenCompraDAO;
	private OrdenCompraDAO ordenCompraDAO;
	private ServicioDAO servicioDAO;
	
	
	public DetalleOrdenCompraDAO getDetalleOrdenCompraDAO() {
		return detalleOrdenCompraDAO;
	}

	public void setDetalleOrdenCompraDAO(DetalleOrdenCompraDAO detalleOrdenCompraDAO) {
		this.detalleOrdenCompraDAO = detalleOrdenCompraDAO;
	}

	public OrdenCompraDAO getOrdenCompraDAO() {
		return ordenCompraDAO;
	}

	public void setOrdenCompraDAO(OrdenCompraDAO ordenCompraDAO) {
		this.ordenCompraDAO = ordenCompraDAO;
	}

	public ServicioDAO getServicioDAO() {
		return servicioDAO;
	}

	public void setServicioDAO(ServicioDAO servicioDAO) {
		this.servicioDAO = servicioDAO;
	}

	@Override
	public List<DetalleOrdenCompra> obtenerLista() throws MyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertarDetalleOrdenCompra(String numero,
			String numOrdenCompra, String refServicio, String cantidad,
			String valor, String observaciones) throws MyException {
		
		DetalleOrdenCompra detalleOrdenCompra = null;
		OrdenCompra ordenCompra = null;
		Servicio servicio = null;
		
		if(numero == null || numero.isEmpty()){
			throw new MyException("El número no puede ser vacío");
		}
		if(numOrdenCompra == null || numOrdenCompra.isEmpty()){
			throw new MyException("El número de orden de compra no puede ser vacio");
		}
		if(refServicio == null || refServicio.isEmpty()){
			throw new MyException("La referencia del servicio no pueden ser vacia");
		}
		if(cantidad == null || cantidad.isEmpty()){
			throw new MyException("La cantidad no puede ser vacio");
		}
		if(valor == null || valor.isEmpty()){
			throw new MyException("El valor no puede ser vacio");
		}
		if(observaciones == null || observaciones.isEmpty()){
			throw new MyException("Las observaciones no puede ser vacia");
		}

		if(detalleOrdenCompraDAO.get(Integer.parseInt(numero))!= null){
			throw new MyException("Ya existe un detalle con este número para la orden de compra en el sistema");
		}
		
		ordenCompra = ordenCompraDAO.get(Integer.parseInt(numOrdenCompra));
		
		if(ordenCompra == null){
			throw new MyException("La orden de comopra a asociar no existe en el sistema");
		}
		
		servicio = servicioDAO.get(refServicio);
		
		if(servicio == null){
			throw new MyException("El servicio a asociar no existe en el sistema");
		}
		detalleOrdenCompra = new DetalleOrdenCompra();
		detalleOrdenCompra.setNumero(Integer.parseInt(numero));
		detalleOrdenCompra.setNumOrdenCompra(ordenCompra);
		detalleOrdenCompra.setRefServicio(servicio);
		detalleOrdenCompra.setCantidad(Integer.parseInt(cantidad));
		detalleOrdenCompra.setValor(Double.parseDouble(valor));
		detalleOrdenCompra.setObservaciones(observaciones);
		
		
		detalleOrdenCompraDAO.insert(detalleOrdenCompra);
		
	}

	@Override
	public void eliminarDetalleOrdenCompra(String numero) throws MyException {
		DetalleOrdenCompra detalleOrdenCompra = null;

		if(numero == null || numero.isEmpty()){
			throw new MyException("El número del detalle de la orden de compra no puede ser vacío");
		}
		detalleOrdenCompra = detalleOrdenCompraDAO.get(Integer.parseInt(numero));
		if(detalleOrdenCompra==null){
			throw new MyException("El detalle de la orden de compra a eliminar no existe en el sistema");
		}
		detalleOrdenCompraDAO.delete(detalleOrdenCompra);
		
	}

	@Override
	public void modificarDetalleOrdenCompra(String numero,
			String numOrdenCompra, String refServicio, String cantidad,
			String valor, String observaciones) throws MyException {
		DetalleOrdenCompra detalleOrdenCompra = null;
		OrdenCompra ordenCompra = null;
		Servicio servicio = null;
		
		if(numero == null || numero.isEmpty()){
			throw new MyException("El número no puede ser vacío");
		}
		if(numOrdenCompra == null || numOrdenCompra.isEmpty()){
			throw new MyException("El número de orden de compra no puede ser vacio");
		}
		if(refServicio == null || refServicio.isEmpty()){
			throw new MyException("La referencia del servicio no pueden ser vacia");
		}
		if(cantidad == null || cantidad.isEmpty()){
			throw new MyException("La cantidad no puede ser vacio");
		}
		if(valor == null || valor.isEmpty()){
			throw new MyException("El valor no puede ser vacio");
		}
		if(observaciones == null || observaciones.isEmpty()){
			throw new MyException("Las observaciones no puede ser vacia");
		}

		ordenCompra = ordenCompraDAO.get(Integer.parseInt(numOrdenCompra));
		
		if(ordenCompra == null){
			throw new MyException("La orden de comopra a asociar no existe en el sistema");
		}
		
		servicio = servicioDAO.get(refServicio);
		
		if(servicio == null){
			throw new MyException("El servicio a asociar no existe en el sistema");
		}
		detalleOrdenCompra = detalleOrdenCompraDAO.get(Integer.parseInt(numero));

		if(detalleOrdenCompra==null){
			throw new MyException("El detalle de la orden de compra a modificar no existe en el sistema");
		}
		
		detalleOrdenCompra.setNumOrdenCompra(ordenCompra);
		detalleOrdenCompra.setRefServicio(servicio);
		detalleOrdenCompra.setCantidad(Integer.parseInt(cantidad));
		detalleOrdenCompra.setValor(Double.parseDouble(valor));
		detalleOrdenCompra.setObservaciones(observaciones);
		
		
		detalleOrdenCompraDAO.update(detalleOrdenCompra);
		
	}

}
