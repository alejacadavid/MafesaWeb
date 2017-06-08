package co.mafesa.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * DTO para la tabla EstadoOC
 * @author Maria Alejandra Cadavid Osorio - mariaa.cadavid@udea.edu.co
 * @since Java 1.7
 * @version 1.0
 */
@XmlRootElement
public class EstadoOC {

	private int numero;
	private Estado estado;
	private Usuario usuarioEstado;
	private int cantidadPendiente;
	private int cantidadProcesada;
	private Date fechaEstado;
	private OrdenCompra idOrdenCompra;
	
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
	 * @return the estado
	 */
	public Estado getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	/**
	 * @return the usuarioEstado
	 */
	public Usuario getUsuarioEstado() {
		return usuarioEstado;
	}
	/**
	 * @param usuarioEstado the usuarioEstado to set
	 */
	public void setUsuarioEstado(Usuario usuarioEstado) {
		this.usuarioEstado = usuarioEstado;
	}
	/**
	 * @return the cantidadPendiente
	 */
	public int getCantidadPendiente() {
		return cantidadPendiente;
	}
	/**
	 * @param cantidadPendiente the cantidadPendiente to set
	 */
	public void setCantidadPendiente(int cantidadPendiente) {
		this.cantidadPendiente = cantidadPendiente;
	}
	/**
	 * @return the cantidadProcesada
	 */
	public int getCantidadProcesada() {
		return cantidadProcesada;
	}
	/**
	 * @param cantidadProcesada the cantidadProcesada to set
	 */
	public void setCantidadProcesada(int cantidadProcesada) {
		this.cantidadProcesada = cantidadProcesada;
	}
	/**
	 * @return the fechaEstado
	 */
	public Date getFechaEstado() {
		return fechaEstado;
	}
	/**
	 * @param fechaEstado the fechaEstado to set
	 */
	public void setFechaEstado(Date fechaEstado) {
		this.fechaEstado = fechaEstado;
	}
	/**
	 * @return the idOrdenCompra
	 */
	public OrdenCompra getIdOrdenCompra() {
		return idOrdenCompra;
	}
	/**
	 * @param idOrdenCompra the idOrdenCompra to set
	 */
	public void setIdOrdenCompra(OrdenCompra idOrdenCompra) {
		this.idOrdenCompra = idOrdenCompra;
	}
	
	
}
