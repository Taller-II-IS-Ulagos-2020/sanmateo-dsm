package cl.ulagos.servlet;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.ulagos.dao.DAOProducto;
import cl.ulagos.modelo.Producto;

@WebServlet(name="IngresarProducto", urlPatterns = {"/controlador/IngresarProducto"})
public class IngresarProductoServlet extends HttpServlet{

	private static final long serialVersionUID = -4821311138626404137L;
	private DAOProducto daoProducto = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException{

		try{
			InitialContext ctx = new InitialContext();
			daoProducto = (DAOProducto) ctx.lookup("java:app/sanmateo/DAOProductoImpl");
		}catch (Exception e) {
			System.out.println("Problema:"+ e);
		}

		String nombre = request.getParameter("nombre");
		String precio = request.getParameter("precio");

		try {
			Producto producto = new Producto();
			producto.setNombre(nombre);
			producto.setPrecio(Integer.parseInt(precio));
			producto.setCliente(null);
			daoProducto.ingresar(producto);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
