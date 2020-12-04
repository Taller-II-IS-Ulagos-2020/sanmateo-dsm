package cl.ulagos.servlet;

import java.util.regex.Pattern;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.ulagos.dao.DAOProducto;
import cl.ulagos.dao.DAOProveedor;
import cl.ulagos.modelo.Producto;
import cl.ulagos.modelo.Proveedor;

@WebServlet(name="AsociarProductoProveedor", urlPatterns = {"/controlador/AsociarProductoProveedor"})
public class AsociarProductoProveedorServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DAOProducto daoProducto= null;
	private DAOProveedor daoProveedor= null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException{
		
		try{
			InitialContext ctx = new InitialContext();
			daoProducto = (DAOProducto) ctx.lookup("java:app/sanmateo/DAOProductoImpl");
		}catch (Exception e) {
			System.out.println("Problema:"+ e);
		}

		try{
			InitialContext ctx = new InitialContext();
			daoProveedor = (DAOProveedor) ctx.lookup("java:app/sanmateo/DAOProveedorImpl");
		}catch (Exception e) {
			System.out.println("Problema:"+ e);
		}

		
		String data = request.getParameter("dtTable");
		data = data.substring(0, data.length()-1);
		String ids[] = data.split(Pattern.quote("|"));
		for (String cC : ids) {
			
			String idProducto = cC.split(Pattern.quote("_"))[0];
			String run = cC.split(Pattern.quote("_"))[1];
			
			Producto producto = new Producto();
			producto.setId(Long.parseLong(idProducto));
			Producto productoBuscado = new Producto();
			
			Proveedor proveedor = new Proveedor();
			proveedor.setRun(Integer.parseInt(run));
			Proveedor proveedorBuscado = new Proveedor();
			
			try {
				proveedorBuscado = daoProveedor.buscar(proveedor);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				productoBuscado = daoProducto.buscar(producto);
				productoBuscado.getProveedor().add(proveedorBuscado);
				daoProducto.modificar(productoBuscado);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
