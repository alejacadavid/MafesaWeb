package co.mafesa.bl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import co.mafesa.dto.Servicio;
import co.mafesa.exception.MyException;
/**
 * Contienen los métodos de la lógica del negocio para la entidad Servicio
 * @author Maria Alejandra Cadavid Osorio - mariaa.cadavid@udea.edu.co
 *
 */
@Transactional
public interface ServicioBL {

	/**
	 * Permite el registro de un servicio
	 * @param refServicio referencia de servicio
	 * @param descripcion descripcion del servicio
	 * @param precioUnitario precio unitario
	 * @throws MyException cuando hay errores realizando el registro de un servicio
	 */
	public void registrarServicio(String refServicio, String descripcion, double precioUnitario) throws MyException;
	
	/**
	 * Retorna la lista de servicios
	 * @return lista de servicios
	 * @throws MyException cuando hay un error retorna la lista de servicios
	 */
	public List<Servicio> obtenerLista() throws MyException;
	
	/**
	 * Elimina un servicio
	 * @param refServicio referencia de servicio
	 * @throws MyException cuando hay un error eliminando un servicio
	 */
	public void eliminarServicio(String refServicio) throws MyException;

	/**
	 * Actualiza la información de un servicio
	 * @param refServicio referencia de servicio
	 * @param descripcion descripcion del servicio
	 * @param precioUnitario precio unitario
	 * @throws MyException cuando hay un error actualizando la informacion d eun servicio
	 */
	public void actualizarServicio(String refServicio, String descripcion, double precioUnitario) throws MyException;

	/**
	 * Busca la informacion de un servicio
	 * @param refServicio referencia de servicio
	 * @return servicio
	 * @throws MyException cuando hay un error buscando el servicio
	 */
	public Servicio buscarServicio(String refServicio) throws MyException;
}
