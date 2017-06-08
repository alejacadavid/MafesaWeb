package co.mafesa.dao.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import co.mafesa.dao.EstadoDAO;
import co.mafesa.dto.Estado;
import co.mafesa.exception.MyException;

public class EstadoDAOHibernate implements EstadoDAO {

	private SessionFactory sessionFactory;

	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void insert(Estado estado) throws MyException {
		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();

			session.save(estado);

		}catch(HibernateException e){
			throw new MyException("Ocurrio un error guardando el estado",e);
		}

	}

	@Override
	public Estado get(int numero) throws MyException {
		Session session = null;
		Estado estado = null;
		try{
			session = sessionFactory.getCurrentSession();
			estado = (Estado)session.get(Estado.class, numero);
		
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error consultando el estado",e);
		}finally{
			if(session != null){
				session.close();
			}
		}
		return estado;
	}

	@Override
	public void update(Estado estado) throws MyException {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			session.update(estado);
			tx.commit();
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error modificando el cliente",e);
		}finally{
			if(session != null){
				session.close();
			}
		}

	}

	@Override
	public void delete(Estado estado) throws MyException {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			session.delete(estado);
			tx.commit();
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error eliminando el estado",e);
		}finally{
			if(session != null){
				session.close();
			}
		}

	}

}
