package co.mafesa.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.mafesa.dao.DetalleOrdenCompraDAO;
import co.mafesa.dto.DetalleOrdenCompra;
import co.mafesa.exception.MyException;

public class DetalleOrdenCompraDAOHibernate implements DetalleOrdenCompraDAO {

	private SessionFactory sessionFactory;

	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	@Override
	public void insert(DetalleOrdenCompra detalleOrdenCompra)
			throws MyException {
		Session session = null;
	
		
		try{
			session = sessionFactory.getCurrentSession();
			
			
			session.save(detalleOrdenCompra);
			
			
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error guardando el detalle de la orden de compra",e);
		}

	}

	@Override
	public DetalleOrdenCompra get(int numero) throws MyException {
		Session session = null;
		DetalleOrdenCompra detalleOrdenCompra = null;
			
		try{
			session = sessionFactory.getCurrentSession();
			detalleOrdenCompra = (DetalleOrdenCompra) session.get(DetalleOrdenCompra.class, numero);
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error consultando el detalle de la orden de compra",e);
		}
		
		return detalleOrdenCompra;
	}

	@Override
	public void update(DetalleOrdenCompra detalleOrdenCompra)
			throws MyException {
		Session session = null;
		
		
		try{
			session = sessionFactory.getCurrentSession();
		
			session.update(detalleOrdenCompra);

		}catch(HibernateException e){
			throw new MyException("Ocurrio un error actualizando el detalle de la orden de compra",e);
		}

	}

	@Override
	public void delete(DetalleOrdenCompra detalleOrdenCompra)
			throws MyException {
		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();
		
			session.delete(detalleOrdenCompra);
		
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error eliminando el detalle de la orden de compra",e);
		}

	}

	@Override
	public List<DetalleOrdenCompra> get() throws MyException {
		Session session = null;
		List<DetalleOrdenCompra> detallesOrdenCompra = new ArrayList<DetalleOrdenCompra>();
		Criteria criteria = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(DetalleOrdenCompra.class);			
			detallesOrdenCompra = criteria.list();
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error consultando el detalle de orden de compra",e);
		}
		
		return detallesOrdenCompra;
	}

}
