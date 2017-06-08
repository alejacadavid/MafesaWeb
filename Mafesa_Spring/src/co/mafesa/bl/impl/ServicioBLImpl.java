package co.mafesa.bl.impl;

import java.util.List;

import co.mafesa.bl.ServicioBL;
import co.mafesa.dao.ServicioDAO;
import co.mafesa.dto.Servicio;
import co.mafesa.exception.MyException;

public class ServicioBLImpl implements ServicioBL {

	private ServicioDAO servicioDAO;
	
	
	public ServicioDAO getServicioDAO() {
		return servicioDAO;
	}

	public void setServicioDAO(ServicioDAO servicioDAO) {
		this.servicioDAO = servicioDAO;
	}

	@Override
	public void registrarServicio(String refServicio, String descripcion,
			double precioUnitario) throws MyException {
		Servicio servicio = null;
		
		if(refServicio == null || refServicio.isEmpty()){
			throw new MyException("La referencia del servicio no puede ser vacío");
		}
		if(descripcion == null || descripcion.isEmpty()){
			throw new MyException("La descripción del servicio no puede ser vacio");
		}
		if(precioUnitario == 0 ){
			throw new MyException("El precio unitario debe ser mayor que 0");
		}

		if(servicioDAO.get(refServicio) != null){
			throw new MyException("Ya existe un servicio con esta referencia en el sistema");
		}
		
		servicio = new Servicio();
		servicio.setRefServicio(refServicio);
		servicio.setDescripcion(descripcion);
		servicio.setPrecioUnitario(precioUnitario);

		servicioDAO.insert(servicio);
		

	}

	@Override
	public List<Servicio> obtenerLista() throws MyException {
		return servicioDAO.get();
	}

	@Override
	public void eliminarServicio(String refServicio) throws MyException {
		Servicio servicio = null;
		
		if(refServicio == null || refServicio.isEmpty()){
			throw new MyException("La referencia del servicio no puede ser vacío");
		}
		
		servicio = servicioDAO.get(refServicio);
		if(servicio==null){
			throw new MyException("El servicio a eliminar no existe en el sistema");
		}
		servicioDAO.delete(servicio);

	}

	@Override
	public void actualizarServicio(String refServicio, String descripcion,
			double precioUnitario) throws MyException {
		Servicio servicio = null;
		
		if(refServicio == null || refServicio.isEmpty()){
			throw new MyException("La referencia del servicio no puede ser vacío");
		}
		if(descripcion == null || descripcion.isEmpty()){
			throw new MyException("La descripción del servicio no puede ser vacio");
		}
		if(precioUnitario == 0 ){
			throw new MyException("El precio unitario del servicio debe ser mayor que 0");
		}

		servicio = servicioDAO.get(refServicio);
		
		if(servicio==null){
			throw new MyException("El servicio a modificar no existe en el sistema");
		}
		
		servicio.setDescripcion(descripcion);
		servicio.setPrecioUnitario(precioUnitario);
	
		servicioDAO.update(servicio);

	}

	@Override
	public Servicio buscarServicio(String refServicio) throws MyException {
		return servicioDAO.get(refServicio);
	}

}
