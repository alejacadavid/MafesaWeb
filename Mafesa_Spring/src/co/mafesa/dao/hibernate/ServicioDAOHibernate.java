package co.mafesa.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import co.mafesa.dao.ServicioDAO;
import co.mafesa.dto.Servicio;
import co.mafesa.exception.MyException;


public class ServicioDAOHibernate implements ServicioDAO {

	private SessionFactory sessionFactory;

	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public List<Servicio> get() throws MyException {
		Session session = null;
		Criteria criteria = null;
		List<Servicio> servicios = new ArrayList<Servicio>();
		
		try{
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(Servicio.class);
			servicios = criteria.list();
		}catch(HibernateException e){
			throw new MyException("Se encontraron errores consultando los servicios",e);
		}
		
		return servicios;
	}

	@Override
	public void insert(Servicio servicio) throws MyException {
		Session session = null;
		
		
		try{
			session = sessionFactory.getCurrentSession();
			
			session.save(servicio);
			
			
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error guardando el servicio",e);
		}

	}

	@Override
	public Servicio get(String refServicio) throws MyException {
		Session session = null;
		Servicio servicio = null;
		try{
			session = sessionFactory.getCurrentSession();
			servicio = (Servicio)session.get(Servicio.class, refServicio);
		
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error consultando el servicio",e);
		}
		
		return servicio;
	}

	@Override
	public void update(Servicio servicio) throws MyException {
		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			
			session.update(servicio);

		}catch(HibernateException e){
			throw new MyException("Ocurrio un error modificando el servicio",e);
		}

	}

	@Override
	public void delete(Servicio servicio) throws MyException {
		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();
		
			session.delete(servicio);
		
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error eliminando el servicio",e);
		}
	}

}
