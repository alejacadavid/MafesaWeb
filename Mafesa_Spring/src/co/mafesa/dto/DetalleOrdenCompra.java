package co.mafesa.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * DTO para la tabla DetalleOrdenCompra
 * @author Maria Alejandra Cadavid Osorio - mariaa.cadavid@udea.edu.co
 * @since Java 1.7
 * @version 1.0
 */
@XmlRootElement
public class DetalleOrdenCompra {
	
	private int numero;
	private OrdenCompra numOrdenCompra;
	private Servicio refServicio;
	private int cantidad;
	private Double valor;
	private String observaciones;
	
	
	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}
	/**
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
	/**
	 * @return the numOrdenCompra
	 */
	public OrdenCompra getNumOrdenCompra() {
		return numOrdenCompra;
	}
	/**
	 * @param numOrdenCompra the numOrdenCompra to set
	 */
	public void setNumOrdenCompra(OrdenCompra numOrdenCompra) {
		this.numOrdenCompra = numOrdenCompra;
	}
	/**
	 * @return the refServicio
	 */
	public Servicio getRefServicio() {
		return refServicio;
	}
	/**
	 * @param refServicio the refServicio to set
	 */
	public void setRefServicio(Servicio refServicio) {
		this.refServicio = refServicio;
	}
	/**
	 * @return the cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}
	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	/**
	 * @return the valor
	 */
	public Double getValor() {
		return valor;
	}
	/**
	 * @param valor the valor to set
	 */
	public void setValor(Double valor) {
		this.valor = valor;
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
