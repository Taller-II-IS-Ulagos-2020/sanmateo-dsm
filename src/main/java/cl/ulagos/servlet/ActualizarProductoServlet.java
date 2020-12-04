package cl.ulagos.servlet;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.ulagos.dao.DAOCliente;
import cl.ulagos.dao.DAOProducto;
import cl.ulagos.modelo.Cliente;
import cl.ulagos.modelo.Producto;

@WebServlet(name="ActualizaProducto", urlPatterns = {"/controlador/ActualizaProducto"})
public class ActualizarProductoServlet  extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DAOProducto daoProducto = null;
	private DAOCliente daoCliente = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException{
		
		try{
			InitialContext ctx = new InitialContext();
			daoProducto = (DAOProducto) ctx.lookup("java:app/sanmateo/DAOProductoImpl");
		}catch (Exception e) {
			System.out.println("Problema:"+ e);
		}
		
		try{
			InitialContext ctx = new InitialContext();
			daoCliente = (DAOCliente) ctx.lookup("java:app/sanmateo/DAOClienteImpl");
		}catch (Exception e) {
			System.out.println("Problema:"+ e);
		}
		
		String idProducto = request.getParameter("idProducto");
		String nombre = request.getParameter("nombre");
		String precio = request.getParameter("precio");
		
		try {

			Producto producto = new Producto();
			producto.setId(Long.parseLong(idProducto));
			Producto productoBuscado = daoProducto.buscar(producto);

			if (productoBuscado !=null) {

				if (productoBuscado.getCliente() !=null)				{
					//Si el producto esta asociado a un cliente 
					Cliente cliente = productoBuscado.getCliente();
					for (int i =0;i<cliente.getProductos().size();i++)
					{
						if (cliente.getProductos().get(i).getId() == producto.getId())
						{
							productoBuscado.setNombre(nombre);
							productoBuscado.setPrecio(Integer.parseInt(precio));
							cliente.getProductos().set(i, productoBuscado);
							daoCliente.modificar(cliente);
							break;
						}
					}
				}
				else
				{
					//Si el producto no esta asociado lo actualizamos
					productoBuscado.setNombre(nombre);
					productoBuscado.setPrecio(Integer.parseInt(precio));
					daoProducto.modificar(productoBuscado);
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
