package cl.ulagos.dao;

import java.util.List;

import cl.ulagos.modelo.Producto;

public interface DAOProducto {

	public void ingresar(Producto producto) throws Exception;
	public void eliminar(Producto producto) throws Exception;
	public void modificar(Producto producto) throws Exception;
	public Producto buscar(Producto producto) throws Exception;
	public List<Producto> listar() throws Exception;
}
