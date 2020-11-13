package cl.ulagos.servlet;

import java.io.PrintWriter;
import java.util.List;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import cl.ulagos.dao.DAOCliente;
import cl.ulagos.modelo.Cliente;

@WebServlet(name="ListarCliente", urlPatterns = {"/controlador/ListarCliente"})
public class ListarClienteServlet extends HttpServlet {

	private static final long serialVersionUID = 3522425561689961750L;
	private DAOCliente daoCliente = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException{

		try{
			InitialContext ctx = new InitialContext();
			daoCliente = (DAOCliente) ctx.lookup("java:app/sanmateo/DAOClienteImpl");
		}catch (Exception e) {
			System.out.println("Problema:"+ e);
		}

		try {

			PrintWriter out = response.getWriter();
			response.setContentType("application/json");

			List<Cliente> clientes = daoCliente.listar();
			JsonArray datos = new JsonArray();

			for (Cliente c: clientes)
			{
				JsonArray fila = new JsonArray();
				fila.add(c.getRun());
				fila.add(c.getNombre());
				datos.add(fila);
			}

			JsonObject miembros = new JsonObject();
			miembros.addProperty("echo","1"); //important case-sensitive
			miembros.addProperty("recordsTotal", clientes.size());
			miembros.addProperty("recordsFiltered", clientes.size());

			miembros.add("data", datos);
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String json2 = gson.toJson(miembros);
			out.print(json2);
		

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
