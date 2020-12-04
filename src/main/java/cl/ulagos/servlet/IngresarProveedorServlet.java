package cl.ulagos.servlet;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.ulagos.dao.DAOProveedor;
import cl.ulagos.modelo.Proveedor;

@WebServlet(name="IngresarProveedor", urlPatterns = {"/controlador/IngresarProveedor"})
public class IngresarProveedorServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DAOProveedor daoProveedor;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException{

		try{
			InitialContext ctx = new InitialContext();
			daoProveedor = (DAOProveedor) ctx.lookup("java:app/sanmateo/DAOProveedorImpl");
		}catch (Exception e) {
			System.out.println("Problema:"+ e);
		}

		String run = request.getParameter("run");
		run = run.replaceAll("\\.", "").split("-")[0];
		String nombre = request.getParameter("nombre");
		int telefono = Integer.parseInt(request.getParameter("telefono"));
		String direccion = request.getParameter("direccion");
		
		try {
			int runI = Integer.parseInt(run);
			Proveedor proveedor = new Proveedor();
			proveedor.setRun(runI);
			proveedor.setNombre(nombre);
			proveedor.setTelefono(telefono);
			proveedor.setDireccion(direccion);
			daoProveedor.ingresar(proveedor);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
