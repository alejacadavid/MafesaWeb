package co.mafesa.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.mafesa.dao.FacturaDAO;
import co.mafesa.dto.Factura;
import co.mafesa.exception.MyException;

public class FacturaDAOHibernate implements FacturaDAO {

	private SessionFactory sessionFactory;

	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Factura> get() throws MyException {
		Session session = null;
		Criteria criteria = null;
		List<Factura> facturas = new ArrayList<Factura>();
		
		try{
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(Factura.class);
			facturas = criteria.list();
		}catch(HibernateException e){
			throw new MyException("Se encontraron errores consultando las facturas",e);
		
		}
		return facturas;
	}

	@Override
	public void insert(Factura factura) throws MyException {
		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			
			session.save(factura);
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error guardando la factura",e);
		}


	}

	@Override
	public Factura get(int numero) throws MyException {
		Session session = null;
		Factura factura = null;
		try{
			session = sessionFactory.getCurrentSession();
			factura = (Factura)session.get(Factura.class, numero);
		
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error consultando la factura",e);
		}
		return factura;
	}

	@Override
	public void update(Factura factura) throws MyException {
		Session session = null;
		
		
		try{
			session = sessionFactory.getCurrentSession();
			
			session.update(factura);
		
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error modificando la factura",e);
		}

	}

}
