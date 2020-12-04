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

import cl.ulagos.dao.DAOProducto;
import cl.ulagos.modelo.Producto;

@WebServlet(name="ListarProducto", urlPatterns = {"/controlador/ListarProducto"})
public class ListarProductoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DAOProducto daoProducto = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException{

		try{
			InitialContext ctx = new InitialContext();
			daoProducto = (DAOProducto) ctx.lookup("java:app/sanmateo/DAOProductoImpl");
		}catch (Exception e) {
			System.out.println("Problema:"+ e);
		}

		try {

			PrintWriter out = response.getWriter();
			response.setContentType("application/json");

			List<Producto> productos = daoProducto.listar();
			JsonArray datos = new JsonArray();

			for (Producto p: productos)
			{
				JsonArray fila = new JsonArray();
				fila.add(p.getId());
				fila.add(p.getNombre());
				fila.add(p.getPrecio());
				datos.add(fila);
			}

			JsonObject miembros = new JsonObject();
			miembros.addProperty("echo","1"); //important case-sensitive
			miembros.addProperty("recordsTotal", productos.size());
			miembros.addProperty("recordsFiltered", productos.size());

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
