package cl.ulagos.dao;

import java.util.List;

import cl.ulagos.modelo.Producto;

public interface DAOProducto {

	public List<Producto> listar() throws Exception;
}
