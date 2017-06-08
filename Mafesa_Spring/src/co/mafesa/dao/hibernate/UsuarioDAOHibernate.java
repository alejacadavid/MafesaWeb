package co.mafesa.dao.hibernate;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import co.mafesa.dao.UsuarioDAO;

import co.mafesa.dto.Usuario;
import co.mafesa.exception.MyException;

public class UsuarioDAOHibernate implements UsuarioDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	@Override
	public Usuario get(String nombreUsuario) throws MyException {
		Session session = null;
		Usuario usuario = null;
		try{
			session = sessionFactory.getCurrentSession();
			usuario = (Usuario)session.get(Usuario.class, nombreUsuario);
		
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error consultando el usuario",e);
		}
		
		return usuario;
	}

	@Override
	public List<Usuario> get() throws MyException {
		Session session = null;
		Criteria criteria = null;
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		try{
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(Usuario.class);
			usuarios = criteria.list();
		}catch(HibernateException e){
			throw new MyException("Se encontraron errores consultando los usuarios",e);
		}
		
		return usuarios;
	}

	@Override
	public void insert(Usuario usuario) throws MyException {
		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			session.save(usuario);
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error guardando los usuarios",e);
		}
		
	}

	@Override
	public void update(Usuario usuario) throws MyException {
		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			session.update(usuario);
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error modificando el usuario",e);
		}
		
	}

	@Override
	public void delete(Usuario usuario) throws MyException {
		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();
		
			session.delete(usuario);
		
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error eliminando el usuario",e);
		}
	}
	

}
