package co.mafesa.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.mafesa.dao.RolDAO;
import co.mafesa.dto.Rol;
import co.mafesa.exception.MyException;


public class RolDAOHibernate implements RolDAO {

	private SessionFactory sessionFactory;

	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Rol> get() throws MyException {
		Session session = null;
		List<Rol> rols = new ArrayList<Rol>();
		Criteria criteria = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(Rol.class);			
			rols = criteria.list();
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error consultando los rols",e);
		}
		
		return rols;
		
	}

	@Override
	public void insert(Rol rol) throws MyException {
		Session session = null;
	
		
		try{
			session = sessionFactory.getCurrentSession();
			
			
			session.save(rol);
			
			
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error guardando los rols",e);
		}
	}

	@Override
	public Rol get(String cedula) throws MyException {
		Session session = null;
		Rol rol = null;
			
		try{
			session = sessionFactory.getCurrentSession();
			rol = (Rol) session.get(Rol.class, cedula);
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error consultando el rol",e);
		}
		
		return rol;
	}

	@Override
	public void update(Rol rol) throws MyException {
		Session session = null;
		
		
		try{
			session = sessionFactory.getCurrentSession();
		
			
			session.update(rol);
			
		
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error actualizando los roles",e);
		}
		
	}

	@Override
	public void delete(Rol rol) throws MyException {
		// TODO Auto-generated method stub
		
	}

}

