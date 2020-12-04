package cl.ulagos.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import cl.ulagos.modelo.Producto;

@Stateless
@LocalBean
public class DAOProductoImpl implements DAOProducto {

	@PersistenceContext
	protected EntityManager em;
	
	
	@Override
	public List<Producto> listar() throws Exception {
		// TODO Auto-generated method stub
		TypedQuery<Producto> query= em.createQuery("From Producto", Producto.class); 
		List<Producto> listaProducto = query.getResultList();
		return listaProducto;
	}


	@Override
	public Producto buscar(Producto producto) throws Exception {
		// TODO Auto-generated method stub
		Producto buscaProducto = em.find(Producto.class, producto.getId());
		return buscaProducto;
		
	}


	@Override
	public void modificar(Producto producto) throws Exception {
		// TODO Auto-generated method stub
		em.merge(producto);
	}


	@Override
	public void ingresar(Producto producto) throws Exception {
		// TODO Auto-generated method stub
		em.persist(producto);
		em.flush();
	}


	@Override
	public void eliminar(Producto producto) throws Exception {
		// TODO Auto-generated method stub
		Producto p = em.merge(producto);
		em.remove(p);
	}
}
