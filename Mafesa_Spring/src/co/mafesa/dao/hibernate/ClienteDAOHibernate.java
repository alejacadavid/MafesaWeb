package co.mafesa.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.mafesa.dao.ClienteDAO;
import co.mafesa.dto.Cliente;
import co.mafesa.exception.MyException;


public class ClienteDAOHibernate implements ClienteDAO {

	private SessionFactory sessionFactory;

	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Cliente> get() throws MyException {
		Session session = null;
		List<Cliente> clientes = new ArrayList<Cliente>();
		Criteria criteria = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(Cliente.class);			
			clientes = criteria.list();
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error consultando los clientes",e);
		}
		
		return clientes;
		
	}

	@Override
	public void insert(Cliente cliente) throws MyException {
		Session session = null;
	
		
		try{
			session = sessionFactory.getCurrentSession();
			
			
			session.save(cliente);
			
			
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error guardando los clientes",e);
		}
	}

	@Override
	public Cliente get(String cedula) throws MyException {
		Session session = null;
		Cliente cliente = null;
			
		try{
			session = sessionFactory.getCurrentSession();
			cliente = (Cliente) session.get(Cliente.class, cedula);
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error consultando el cliente",e);
		}
		
		return cliente;
	}

	@Override
	public void update(Cliente cliente) throws MyException {
		Session session = null;
		
		
		try{
			session = sessionFactory.getCurrentSession();
		
			session.update(cliente);

		}catch(HibernateException e){
			throw new MyException("Ocurrio un error actualizando los clientes",e);
		}
		
	}

	@Override
	public void delete(Cliente cliente) throws MyException {
		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();
		
			session.delete(cliente);
		
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error eliminando el cliente",e);
		}
	}


}
