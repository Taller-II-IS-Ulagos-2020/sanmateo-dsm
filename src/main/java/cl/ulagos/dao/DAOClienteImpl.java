package cl.ulagos.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
		
	}

	@Override
	public void eliminar(Cliente cliente) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cliente> listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
