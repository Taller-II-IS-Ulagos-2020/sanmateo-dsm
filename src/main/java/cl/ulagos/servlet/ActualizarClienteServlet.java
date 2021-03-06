package cl.ulagos.servlet;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.ulagos.dao.DAOCliente;
import cl.ulagos.modelo.Cliente;

@WebServlet(name="ActualizaCliente", urlPatterns = {"/controlador/ActualizaCliente"})
public class ActualizarClienteServlet extends HttpServlet{


	private static final long serialVersionUID = 3161206052718206619L;
	private DAOCliente daoCliente = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException{

		try{
			InitialContext ctx = new InitialContext();
			daoCliente = (DAOCliente) ctx.lookup("java:app/sanmateo/DAOClienteImpl");
		}catch (Exception e) {
			System.out.println("Problema:"+ e);
		}

		String run = request.getParameter("run");
		run = run.replaceAll("\\.", "").split("-")[0];
		String nombre = request.getParameter("nombre");


		try {
			int runI = Integer.parseInt(run);
			Cliente cliente = daoCliente.buscar(new Cliente(runI));

			if (cliente != null) {
				cliente.setNombre(nombre);
				daoCliente.modificar(cliente);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
