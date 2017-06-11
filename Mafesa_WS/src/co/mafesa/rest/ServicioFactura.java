package co.mafesa.rest;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.mafesa.bl.FacturaBL;
import co.mafesa.dto.Factura;
import co.mafesa.exception.MyException;

/**
 * Implementacion de los servicios web de la logica de negocio para los estados de una factura
 * @author Maria Alejandra Cadavid Osorio - mariaa.cadavid@udea.edu.co
 *
 */
@Path("Factura")
@Component
public class ServicioFactura {
	
	@Autowired
	private FacturaBL facturaService;
	
	/**
	 * Lista las facturas
	 * @return lista de estados
	 * @throws RemoteException cuando hay un error retornando los estados
	 */
	@Path("list")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public List<Factura> obtener() throws RemoteException{
		List<Factura> facturas = new ArrayList<Factura>();
		List<Factura> listaFacturas = null;
		
		try{
			listaFacturas = facturaService.obtenerLista();
				for(Factura factura: listaFacturas){
					Factura facturaWS = new Factura();
					facturaWS.setNumFactura(factura.getNumFactura());
					facturaWS.setFechaFactura(factura.getFechaFactura());
					facturaWS.setFechaVencimiento(factura.getFechaVencimiento());
					facturaWS.setOrdenCompra(factura.getOrdenCompra());
					facturaWS.setValorImpuestos(factura.getValorImpuestos());
					facturaWS.setValorDescuentos(factura.getValorDescuentos());
					facturaWS.setValorTotal(factura.getValorTotal());
					facturaWS.setObservaciones(factura.getObservaciones());
					
					facturas.add(facturaWS);
				}
			}catch(MyException e){
				throw new RemoteException(e.getMessage());
			}

		return facturas;
	}
	
	/**
	 * Metodo para generar la factura
	 * @param numFactura numero de factura
	 * @param fechaVencimiento fecha de vencimiento
	 * @param numOrdenCompra numero de orden de compra
	 * @param valorImpuestos valor de impuestos
	 * @param valorDescuentos valor de descuentos
	 * @param observaciones obsrvaciones
	 * @return mensaje de confirmacion
	 * @throws RemoteException cuando hay un error generando la factura
	 * @throws ParseException
	 */
	@Produces(MediaType.TEXT_PLAIN)
	@POST
	public String generarFactura(@QueryParam("numFactura")String numFactura, @QueryParam("fechaVencimiento")String fechaVencimiento,
			@QueryParam("numOrdenCompra")String numOrdenCompra, @QueryParam("valorImpuestos")String valorImpuestos, 
			@QueryParam("valorDescuentos")String valorDescuentos, @QueryParam("observaciones")String observaciones) throws RemoteException, ParseException{
		try{
			facturaService.generarFactura(numFactura, fechaVencimiento, numOrdenCompra, valorImpuestos, valorDescuentos, observaciones);
			
			return "Factura guardada correctamente";
		}catch(MyException e){
			return e.getMessage();
		}
		
		
	}
	
	/**
	 * Metodo para actualizar la informacion de una factura
	 * @param numFactura numero de factura
	 * @param fechaVencimiento fecha de vencimiento
	 * @param numOrdenCompra numero de orden de compra
	 * @param valorImpuestos valor de impuestos
	 * @param valorDescuentos valor de descuentos
	 * @param observaciones obsrvaciones
	 * @return mensaje de confirmacion
	 * @throws RemoteException cuando hay un error actualizando la factura
	 * @throws ParseException
	 */
	@Path("update")
	@Produces(MediaType.APPLICATION_XML)
	@PUT
	public String actualizarFactura(@QueryParam("numFactura")String numFactura, @QueryParam("fechaVencimiento")String fechaVencimiento,
			@QueryParam("numOrdenCompra")String numOrdenCompra, @QueryParam("valorImpuestos")String valorImpuestos, 
			@QueryParam("valorDescuentos")String valorDescuentos, @QueryParam("observaciones")String observaciones) throws RemoteException, ParseException{
		try{
			facturaService.modificarFactura(numFactura, fechaVencimiento, numOrdenCompra, valorImpuestos, valorDescuentos, observaciones);
			
		}catch(MyException e){
			return e.getMessage();
		}
		
		return "";
	}

}
