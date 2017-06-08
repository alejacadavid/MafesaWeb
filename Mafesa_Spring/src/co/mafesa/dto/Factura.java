package co.mafesa.dto;

import java.util.Date;

/**
 * DTO para la tabla Factura
 * @author Maria Alejandra Cadavid Osorio - mariaa.cadavid@udea.edu.co
 * @since Java 1.7
 * @version 1.0
 */
public class Factura {

	private int numFactura;
	private Date fechaFactura;
	private Date fechaVencimiento;
	private OrdenCompra ordenCompra;
	private Double valorImpuestos;
	private Double valorDescuentos;
	private Double valorTotal;
	private String observaciones;
	/**
	 * @return the numFactura
	 */
	public int getNumFactura() {
		return numFactura;
	}
	/**
	 * @param numFactura the numFactura to set
	 */
	public void setNumFactura(int numFactura) {
		this.numFactura = numFactura;
	}
	/**
	 * @return the fechaFactura
	 */
	public Date getFechaFactura() {
		return fechaFactura;
	}
	/**
	 * @param fechaFactura the fechaFactura to set
	 */
	public void setFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}
	/**
	 * @return the fechaVencimiento
	 */
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	/**
	 * @param fechaVencimiento the fechaVencimiento to set
	 */
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	/**
	 * @return the ordenCompra
	 */
	public OrdenCompra getOrdenCompra() {
		return ordenCompra;
	}
	/**
	 * @param ordenCompra the ordenCompra to set
	 */
	public void setOrdenCompra(OrdenCompra ordenCompra) {
		this.ordenCompra = ordenCompra;
	}
	/**
	 * @return the valorImpuestos
	 */
	public Double getValorImpuestos() {
		return valorImpuestos;
	}
	/**
	 * @param valorImpuestos the valorImpuestos to set
	 */
	public void setValorImpuestos(Double valorImpuestos) {
		this.valorImpuestos = valorImpuestos;
	}
	/**
	 * @return the valorDescuentos
	 */
	public Double getValorDescuentos() {
		return valorDescuentos;
	}
	/**
	 * @param valorDescuentos the valorDescuentos to set
	 */
	public void setValorDescuentos(Double valorDescuentos) {
		this.valorDescuentos = valorDescuentos;
	}
	/**
	 * @return the valorTotal
	 */
	public Double getValorTotal() {
		return valorTotal;
	}
	/**
	 * @param valorTotal the valorTotal to set
	 */
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	/**
	 * @return the observaciones
	 */
	public String getObservaciones() {
		return observaciones;
	}
	/**
	 * @param observaciones the observaciones to set
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	
	
	
}
