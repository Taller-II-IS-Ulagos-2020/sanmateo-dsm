package cl.ulagos.dao;

import java.util.List;

import cl.ulagos.modelo.Proveedor;

public interface DAOProveedor {

	public void ingresar(Proveedor proveedor) throws Exception;
	public void modificar(Proveedor proveedor) throws Exception;
	public void eliminar(Proveedor proveedor) throws Exception;
	public Proveedor buscar(Proveedor proveedor) throws Exception;
	public List<Proveedor> listar() throws Exception;
	
}
