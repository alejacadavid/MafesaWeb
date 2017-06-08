package co.mafesa.dao;

import java.util.List;

import co.mafesa.dto.Factura;
import co.mafesa.exception.MyException;
/**
 * Interface que define los métodos permitidos para las facturas
 * @author Maria Alejandra Cadavid Osorio - mariaa.cadavid@udea.edu.co
 * @since Java 1.7
 * @version 1.0
 */
public interface FacturaDAO {
	/**
	 * Obtiene la lista de facturas que existen en el sistema 
	 * @return Lista de facturas
	 * @throws MyException ocurre cuando hay un problema con la conexión a la BD
	 */
	public List<Factura> get() throws MyException;
	
	 /** Inserta la información de una factura
	 * @param factura factura
	 * @throws MyException cuando hay un error insertando
	 */
	public void insert(Factura factura) throws MyException;
	
	/**
	 * Entrega la información de una factura dado su numero
	 * @param numero numero de factura
	 * @return factura
	 * @throws MyException cuando hay un error consultado
	 */
	public Factura get(int numero) throws MyException;
	
	/**
	 * Modifca los datos de una factura en la base de datos
	 * @param factura objeto {@link Factura} con la información a modificar
	 * @throws MyException cuando hay un error modificando la información
	 */
	public void update(Factura factura) throws MyException;
	
}
