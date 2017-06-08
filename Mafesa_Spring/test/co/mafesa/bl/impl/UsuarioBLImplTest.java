package co.mafesa.bl.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.mafesa.bl.UsuarioBL;
import co.mafesa.dto.Usuario;
import co.mafesa.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:configuracion.xml")
@Transactional
public class UsuarioBLImplTest {
	
	@Autowired
	UsuarioBL usuarioBL;
	
	@Test
	public void testAutenticar() {
		try{
			usuarioBL.autenticar("alejacad", "");
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testGuardar() {

		try{
			usuarioBL.registrarUsuario("111111","CC","1032451523","Felipe","Serna","Calle 25", "8529674","juan@correo.com","123456","KLL0502");
			
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testObtener() {
		List<Usuario> lista = null;
		try{
			lista = usuarioBL.obtenerLista();
			
			assertTrue(lista.size() > 0);
			
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
