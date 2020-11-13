package cl.ulagos.dao;

import java.util.List;

import cl.ulagos.modelo.Cliente;

public interface DAOCliente {

	public void ingresar(Cliente cliente) throws Exception;
	public void modificar(Cliente cliente) throws Exception;
	public void eliminar(Cliente cliente) throws Exception;
	public Cliente buscar(Cliente cliente) throws Exception;
	public List<Cliente> listar() throws Exception;
}
