package cl.ulagos.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import cl.ulagos.modelo.Producto;

@Stateless
@LocalBean
public class DAOProductoImpl implements DAOProducto {

	@Override
	public List<Producto> listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
}
