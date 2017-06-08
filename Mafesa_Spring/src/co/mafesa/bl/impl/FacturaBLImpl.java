package co.mafesa.bl.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import co.mafesa.bl.FacturaBL;
import co.mafesa.dao.FacturaDAO;
import co.mafesa.dao.OrdenCompraDAO;
import co.mafesa.dto.Factura;
import co.mafesa.dto.OrdenCompra;
import co.mafesa.exception.MyException;

public class FacturaBLImpl implements FacturaBL {

	private FacturaDAO facturaDAO;
	private OrdenCompraDAO ordenCompraDAO;
	
	public FacturaDAO getFacturaDao() {
		return facturaDAO;
	}

	public void setFacturaDAO(FacturaDAO facturaDAO) {
		this.facturaDAO = facturaDAO;
	}

	public OrdenCompraDAO getOrdenCompraDAO() {
		return ordenCompraDAO;
	}

	public void setOrdenCompraDAO(OrdenCompraDAO ordenCompraDAO) {
		this.ordenCompraDAO = ordenCompraDAO;
	}

	@Override
	public List<Factura> obtenerLista() throws MyException {
		return facturaDAO.get();
	}

	@Override
	public void generarFactura(String numFactura, String fechaVencimiento,
			String numOrdenCompra, String valorImpuestos,
			String valorDescuentos, String observaciones) throws MyException,
			ParseException {
		Factura factura = null;
		OrdenCompra ordenCompra = null;
		
		if(numFactura == null || numFactura.isEmpty()){
			throw new MyException("El numero de la factura no puede ser vacía");
		}
		if(fechaVencimiento == null || fechaVencimiento.isEmpty()){
			throw new MyException("La fecha de vencimiento de la factura no puede ser vacio");
		}
		if(numOrdenCompra == null || numOrdenCompra.isEmpty()){
			throw new MyException("El numero de orden de compra no pueden ser vacio");
		}
		if(valorImpuestos == null || valorImpuestos.isEmpty()){
			throw new MyException("El valor de las impuestos no puede ser vacia");
		}
		if(observaciones == null || observaciones.isEmpty()){
			throw new MyException("Las observaciones de la factura no puede ser vacia");
		}
		
		if(facturaDAO.get(Integer.parseInt(numFactura)) != null){
			throw new MyException("Ya existe una factura con este número en el sistema");
		}
		
		factura = new Factura();
		factura.setNumFactura(Integer.parseInt(numFactura));
		factura.setFechaFactura(new Date());
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		factura.setFechaVencimiento(sdf.parse(fechaVencimiento));
		
		ordenCompra = ordenCompraDAO.get(Integer.parseInt(numOrdenCompra));
		
		if(ordenCompra==null){
			throw new MyException("La orden de compra a asociar no existe en el sistema");
		}
		factura.setOrdenCompra(ordenCompra);
		factura.setValorImpuestos(Double.parseDouble(valorImpuestos));
		factura.setValorDescuentos(Double.parseDouble(valorDescuentos));
		double valorTotal = ordenCompra.getValorTotal()+Double.parseDouble(valorImpuestos)-Double.parseDouble(valorDescuentos);
		factura.setValorTotal(valorTotal);
		factura.setObservaciones(observaciones);
		facturaDAO.insert(factura);

	}

	@Override
	public void modificarFactura(String numFactura, String fechaVencimiento,
			String numOrdenCompra, String valorImpuestos,
			String valorDescuentos, String observaciones) throws MyException,
			ParseException {
		Factura factura = null;
		OrdenCompra ordenCompra = null;
		
		if(numFactura == null || numFactura.isEmpty()){
			throw new MyException("El numero de la factura no puede ser vacía");
		}
		if(fechaVencimiento == null || fechaVencimiento.isEmpty()){
			throw new MyException("La fecha de vencimiento de la factura no puede ser vacio");
		}
		if(numOrdenCompra == null || numOrdenCompra.isEmpty()){
			throw new MyException("El numero de orden de compra no pueden ser vacio");
		}
		if(valorImpuestos == null || valorImpuestos.isEmpty()){
			throw new MyException("El valor de las impuestos no puede ser vacia");
		}
		if(observaciones == null || observaciones.isEmpty()){
			throw new MyException("Las observaciones de la factura no puede ser vacia");
		}
		
		factura = facturaDAO.get(Integer.parseInt(numFactura));
		
		if(factura==null){
			throw new MyException("La factura a modificar no existe en el sistema");
		}
		
		
		factura.setFechaFactura(new Date());
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		factura.setFechaVencimiento(sdf.parse(fechaVencimiento));
		
		ordenCompra = ordenCompraDAO.get(Integer.parseInt(numOrdenCompra));
		
		if(ordenCompra==null){
			throw new MyException("La orden de compra a asociar no existe en el sistema");
		}
		factura.setOrdenCompra(ordenCompra);
		factura.setValorImpuestos(Double.parseDouble(valorImpuestos));
		factura.setValorDescuentos(Double.parseDouble(valorDescuentos));
		double valorTotal = ordenCompra.getValorTotal()+Double.parseDouble(valorImpuestos)-Double.parseDouble(valorDescuentos);
		factura.setValorTotal(valorTotal);
		factura.setObservaciones(observaciones);

		facturaDAO.update(factura);
		

	}

	@Override
	public Factura buscarFactura(String numFactura) throws MyException {
		return facturaDAO.get(Integer.parseInt(numFactura));
	}

	

}
