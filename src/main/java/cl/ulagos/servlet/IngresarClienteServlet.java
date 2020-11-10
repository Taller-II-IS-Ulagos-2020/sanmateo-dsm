package cl.ulagos.servlet;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.ulagos.dao.DAOCliente;
import cl.ulagos.modelo.Cliente;

@WebServlet(name="IngresarCliente", urlPatterns = {"/controlador/IngresarCliente"})
public class IngresarClienteServlet extends HttpServlet{


	private static final long serialVersionUID = -4821311138626404137L;
	private static DAOCliente daoCliente = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException{

		try{
			InitialContext ctx = new InitialContext();
			daoCliente = (DAOCliente) ctx.lookup("java:app/sanmateo/DAOClienteImpl");
		}catch (Exception e) {
			System.out.println("Problema:"+ e);
		}

		String run = request.getParameter("run");
		String nombre = request.getParameter("nombre");

		try {
			int runI = Integer.parseInt(run);
			daoCliente.ingresar(new Cliente(runI,nombre));
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
