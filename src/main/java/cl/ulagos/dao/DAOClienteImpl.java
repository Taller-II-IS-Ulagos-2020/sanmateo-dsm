package cl.ulagos.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import cl.ulagos.modelo.Cliente;

@Stateless
@LocalBean
public class DAOClienteImpl implements DAOCliente {

	
	@PersistenceContext
	protected EntityManager em;
	
	
	@Override
	public void ingresar(Cliente cliente) throws Exception {
		// TODO Auto-generated method stub
		em.persist(cliente);
		em.flush();
	}

	@Override
	public void modificar(Cliente cliente) throws Exception {
		// TODO Auto-generated method stub
		em.merge(cliente);
	}

	@Override
	public Cliente buscar(Cliente cliente) throws Exception {
		// TODO Auto-generated method stub
		Cliente buscaCliente = em.find(Cliente.class, cliente.getRun());
		return buscaCliente;
	}
	@Override
	public void eliminar(Cliente cliente) throws Exception {
		// TODO Auto-generated method stub
		Cliente c = em.merge(cliente);
		em.remove(c);
	}

	@Override
	public List<Cliente> listar() throws Exception {
		// TODO Auto-generated method stub
		TypedQuery<Cliente> query= em.createQuery("From Cliente", Cliente.class); 
		List<Cliente> listaCliente = query.getResultList();
		return listaCliente;
	}

}
