package co.mafesa.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.mafesa.dao.OrdenCompraDAO;
import co.mafesa.dto.OrdenCompra;
import co.mafesa.exception.MyException;


public class OrdenCompraDAOHibernate implements OrdenCompraDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public List<OrdenCompra> get() throws MyException {
		Session session = null;
		Criteria criteria = null;
		List<OrdenCompra> ordenesCompra = new ArrayList<OrdenCompra>();
		
		try{
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(OrdenCompra.class);
			ordenesCompra = criteria.list();
			
		}catch(HibernateException e){
			throw new MyException("Se encontraron errores consultando las ordenes de compra",e);
		}
		
		return ordenesCompra;
	}

	@Override
	public void insert(OrdenCompra ordenCompra) throws MyException {
		Session session = null;
	
		
		try{
			session = sessionFactory.getCurrentSession();
		
			session.save(ordenCompra);
			
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error guardando la orden de compra",e);
		}

	}

	@Override
	public OrdenCompra get(int numero) throws MyException {
		Session session = null;
		OrdenCompra ordenCompra = null;
		try{
			session = sessionFactory.getCurrentSession();
			ordenCompra = (OrdenCompra)session.get(OrdenCompra.class, numero);
		
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error consultando la orden de compra",e);
		}
		
		return ordenCompra;
	}

	@Override
	public void update(OrdenCompra ordenCompra) throws MyException {
		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			session.update(ordenCompra);
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error modificando la orden de compra",e);
		}
		

	}

	@Override
	public void delete(OrdenCompra ordenCompra) throws MyException {
		Session session = null;
		try{
			session = sessionFactory.getCurrentSession();
		
			session.delete(ordenCompra);
	
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error eliminando la orden de compra",e);
		}

	}

}
