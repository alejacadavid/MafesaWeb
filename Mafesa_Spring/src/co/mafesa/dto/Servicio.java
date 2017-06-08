package co.mafesa.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * DTO para la tabla Servicio
 * @author Maria Alejandra Cadavid Osorio - mariaa.cadavid@udea.edu.co
 * @since Java 1.7
 * @version 1.0
 */
@XmlRootElement
public class Servicio {

	private String refServicio;
	private String descripcion;
	private double precioUnitario;
	
	/**
	 * @return la referencia
	 */
	public String getRefServicio() {
		return refServicio;
	}
	/**
	 * @param refServicio la referencia a ingresar
	 */
	public void setRefServicio(String refServicio) {
		this.refServicio = refServicio;
	}
	/**
	 * @return la descripción
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion la descripción a ingresar
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return el precio unitario
	 */
	public double getPrecioUnitario() {
		return precioUnitario;
	}
	/**
	 * @param precioUnitario el precio unitario a ingresar
	 */
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	
	

	
}
