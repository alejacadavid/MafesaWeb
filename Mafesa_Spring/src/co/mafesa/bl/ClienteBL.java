package co.mafesa.bl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import co.mafesa.dto.Cliente;
import co.mafesa.exception.MyException;


/**
 * Contienen los métodos de la lógica del negocio para la entidad Cliente
 * @author Maria Alejandra Cadavid Osorio - mariaa.cadavid@udea.edu.co
 *
 */

@Transactional
public interface ClienteBL {
	
	/**
	 * Entrega la lista de clientes del sistema
	 * @return lista de clientes
	 * @throws MyException cuando hay errores obteniendo los clientes del sistema
	 */
	public List<Cliente> obtenerLista() throws MyException;
	
	/**
	 * Crea un cliente en el sistema
	 * @param codigoCliente codigo del cliente
	 * @param tipoid tipo de identificacion
	 * @param numeroIdentificacion numero de identificacion
	 * @param razonSocial razon social
	 * @param Direccion direccion
	 * @param telefono telefono
	 * @param email email
	 * @throws MyException Cuando hay errores creando el cleinte o cuando problemas
	 * de validación de datos
	 */
	public void guardarCliente(String codigoCliente, String tipoid, String numeroIdentificacion, String razonSocial,
			String Direccion, String telefono, String email) throws MyException;

	/**
	 * Elimina un cliente en el sistema
	 * @param codigoCliente codigo del cliente
	 * @throws MyException Cuando hay errores eliminando el cliente
	 */
	public void eliminarCliente(String codigoCliente) throws MyException;

	/**
	 * Actualiza los datos de un cliente creado en el sistema
	 * @param codigoCliente codigo del cliente
	 * @param tipoId tipo de identificaicon
	 * @param numeroIdentificacion numero de identificacion
	 * @param razonSocial razon Social
	 * @param direccion direccion
	 * @param telefono telefono
	 * @param email correo electronico
	 * @throws MyException cuando hay errores actualizando un cliente
	 */
	public void actualizarCliente(String codigoCliente, String tipoId,
			String numeroIdentificacion, String razonSocial, String direccion,
			String telefono, String email) throws MyException;

	/**
	 * Permite obtener informacion de un cliente
	 * @param codigoCliente codigo del cliente
	 * @return el cliente
	 * @throws MyException cuando hay errores buscando un cliente
	 */
	public Cliente buscarCliente(String codigoCliente) throws MyException;
}
