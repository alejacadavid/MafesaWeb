package co.mafesa.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.mafesa.dao.EstadoOCDAO;
import co.mafesa.dto.Cliente;
import co.mafesa.dto.EstadoOC;
import co.mafesa.exception.MyException;

public class EstadoOCDAOHibernate implements EstadoOCDAO {

	private SessionFactory sessionFactory;

	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	@Override
	public void insert(EstadoOC estadoOC) throws MyException {
		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			session.save(estadoOC);
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error guardando el estado",e);
		}
	}

	@Override
	public EstadoOC get(int numero) throws MyException {
		Session session = null;
		EstadoOC estadoOC = null;
		try{
			session = sessionFactory.getCurrentSession();
			estadoOC = (EstadoOC)session.get(EstadoOC.class, numero);
		
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error consultando el estado",e);
		}finally{
			if(session != null){
				session.close();
			}
		}
		
		return estadoOC;
	}

	@Override
	public void update(EstadoOC estadoOC) throws MyException {
		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();
		
			session.update(estadoOC);
	
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error modificando el estado",e);
		}finally{
			if(session != null){
				session.close();
			}
		}
	}

	@Override
	public void delete(EstadoOC estadoOC) throws MyException {
		Session session = null;
	
		
		try{
			session = sessionFactory.getCurrentSession();
		
			session.delete(estadoOC);
		
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error eliminando el estado",e);
		}finally{
			if(session != null){
				session.close();
			}
		}

	}

	@Override
	public List<EstadoOC> get() throws MyException {
		Session session = null;
		List<EstadoOC> estadosOC = new ArrayList<EstadoOC>();
		Criteria criteria = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(Cliente.class);			
			estadosOC = criteria.list();
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error consultando los estados",e);
		}
		
		return estadosOC;
	}

}
