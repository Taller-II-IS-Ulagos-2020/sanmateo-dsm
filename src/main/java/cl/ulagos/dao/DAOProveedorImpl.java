package cl.ulagos.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import cl.ulagos.modelo.Proveedor;

@Stateless
@LocalBean
public class DAOProveedorImpl implements DAOProveedor {

	@PersistenceContext
	protected EntityManager em;
	
	@Override
	public void ingresar(Proveedor proveedor) throws Exception {
		// TODO Auto-generated method stub
		em.persist(proveedor);
		em.flush();
	}

	@Override
	public void modificar(Proveedor proveedor) throws Exception {
		// TODO Auto-generated method stub
		em.merge(proveedor);
	}

	@Override
	public void eliminar(Proveedor proveedor) throws Exception {
		// TODO Auto-generated method stub
		Proveedor p = em.merge(proveedor);
		em.remove(p);
	}

	@Override
	public Proveedor buscar(Proveedor proveedor) throws Exception {
		// TODO Auto-generated method stub
		Proveedor buscaProveedor = em.find(Proveedor.class, proveedor.getRun());
		return buscaProveedor;
	}

	@Override
	public List<Proveedor> listar() throws Exception {
		// TODO Auto-generated method stub
		TypedQuery<Proveedor> query= em.createQuery("From Proveedor", Proveedor.class); 
		List<Proveedor> listaProveedor = query.getResultList();
		return listaProveedor;
	}
	
}
