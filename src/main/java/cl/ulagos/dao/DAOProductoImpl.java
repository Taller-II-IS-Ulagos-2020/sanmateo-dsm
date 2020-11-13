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
}
