package co.mafesa.dto;

import java.util.Date;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * DTO para la tabla Orden de Compra
 * @author Maria Alejandra Cadavid Osorio - mariaa.cadavid@udea.edu.co
 * @since Java 1.7
 * @version 1.0
 */
@XmlRootElement
public class OrdenCompra {

	private Integer numero;
	private String formaPago;
	private Integer plazoEntrega;
	private Date fechaEntrega;
	private String direccionEntrega;
	private Double valorTotal;
	private Usuario usuarioCrea;
	private Date fechaCreacion;
	private Usuario usuarioModifica;
	private Date fechaModifica;
	private Boolean Eliminado;
	private Usuario usuarioElimina;
	private Date fechaElimina;
	private Cliente cliente;
	
	private Set<DetalleOrdenCompra> detalleOrdenCompra;
	private Set<EstadoOC> estadoOC;
	
	/**
	 * @return El número de la orden de compra
	 */
	public Integer getNumero() {
		return numero;
	}
	/**
	 * @param numero El número de la orden de compra a ingresar
	 */
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	/**
	 * @return La forma de pago
	 */
	public String getFormaPago() {
		return formaPago;
	}
	/**
	 * @param formaPago La forma de pago a ingresar
	 */
	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	/**
	 * @return El plazo de entrega
	 */
	public Integer getPlazoEntrega() {
		return plazoEntrega;
	}
	/**
	 * @param plazoEntrega El plazo de entrega a ingresar
	 */
	public void setPlazoEntrega(Integer plazoEntrega) {
		this.plazoEntrega = plazoEntrega;
	}
	/**
	 * @return La fecha de entrega
	 */
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	/**
	 * @param fechaEntrega La fecha de entrega a ingresar
	 */
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	/**
	 * @return La dirección de entrega
	 */
	public String getDireccionEntrega() {
		return direccionEntrega;
	}
	/**
	 * @param direccionEntrega La dirección de entrega
	 */
	public void setDireccionEntrega(String direccionEntrega) {
		this.direccionEntrega = direccionEntrega;
	}
	
	
	/**
	 * @return El valor total
	 */
	public Double getValorTotal() {
		return valorTotal;
	}
	/**
	 * @param valorTotal El valor total a ingresar
	 */
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	/**
	 * @return El usuario que crea la orden
	 */
	public Usuario getUsuarioCrea() {
		return usuarioCrea;
	}
	/**
	 * @param usuarioCrea El usuario que crea 
	 */
	public void setUsuarioCrea(Usuario usuarioCrea) {
		this.usuarioCrea = usuarioCrea;
	}
	/**
	 * @return La fecha de creación de la orden
	 */
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	/**
	 * @param fechaCreacion La fecha de creación de la orden a ingresar
	 */
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	/**
	 * @return El usuario que modifica la orden
	 */
	public Usuario getUsuarioModifica() {
		return usuarioModifica;
	}
	/**
	 * @param usuarioModifica El usuario que modifica la orden a ingresar
	 */
	public void setUsuarioModifica(Usuario usuarioModifica) {
		this.usuarioModifica = usuarioModifica;
	}
	/**
	 * @return La fecha de modificación de la orden
	 */
	public Date getFechaModifica() {
		return fechaModifica;
	}
	/**
	 * @param fechaModifica La fecha de modificación de la orden a ingresar
	 */
	public void setFechaModifica(Date fechaModifica) {
		this.fechaModifica = fechaModifica;
	}
	/**
	 * @return Eliminado
	 */
	public Boolean getEliminado() {
		return Eliminado;
	}
	/**
	 * @param eliminado Si está eliminado
	 */
	public void setEliminado(Boolean eliminado) {
		Eliminado = eliminado;
	}
	/**
	 * @return El usuario que elimina
	 */
	public Usuario getUsuarioElimina() {
		return usuarioElimina;
	}
	/**
	 * @param usuarioElimina El usuario que elimina a ingresar
	 */
	public void setUsuarioElimina(Usuario usuarioElimina) {
		this.usuarioElimina = usuarioElimina;
	}
	/**
	 * @return La fecha de Eliminación
	 */
	public Date getFechaElimina() {
		return fechaElimina;
	}
	/**
	 * @param fechaElimina La fecha de eliminación a ingresar
	 */
	public void setFechaElimina(Date fechaElimina) {
		this.fechaElimina = fechaElimina;
	}
	/**
	 * @return El cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}
	/**
	 * @param cliente El cliente a ingresar
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	/**
	 * @return the detalleOrdenCompra
	 */
	public Set<DetalleOrdenCompra> getDetalleOrdenCompra() {
		return detalleOrdenCompra;
	}
	/**
	 * @param detalleOrdenCompra the detalleOrdenCompra to set
	 */
	public void setDetalleOrdenCompra(Set<DetalleOrdenCompra> detalleOrdenCompra) {
		this.detalleOrdenCompra = detalleOrdenCompra;
	}
	/**
	 * @return the estadoOC
	 */
	public Set<EstadoOC> getEstadoOC() {
		return estadoOC;
	}
	/**
	 * @param estadoOC the estadoOC to set
	 */
	public void setEstadoOC(Set<EstadoOC> estadoOC) {
		this.estadoOC = estadoOC;
	}
	
	
	
	
	
	
	
}
