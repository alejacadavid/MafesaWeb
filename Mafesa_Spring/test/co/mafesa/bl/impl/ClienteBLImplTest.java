package co.mafesa.bl.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.mafesa.bl.ClienteBL;
import co.mafesa.dto.Cliente;
import co.mafesa.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:configuracion.xml")
@Transactional
public class ClienteBLImplTest {

	@Autowired
	ClienteBL clienteBL;
	
	@Test
	public void testObtener() {
		List<Cliente> lista = null;
		try{
			lista = clienteBL.obtenerLista();
			
			assertTrue(lista.size() > 0);
			
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testGuardar() {

		try{
			clienteBL.guardarCliente("ALE8552","NIT","890980577","COCACOLA","Medellin","8526341","cocacola@cocacola.com");
			
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
