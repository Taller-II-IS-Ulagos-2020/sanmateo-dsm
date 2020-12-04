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
import cl.ulagos.dao.DAOProveedor;
import cl.ulagos.modelo.Producto;
import cl.ulagos.modelo.Proveedor;

@WebServlet(name="MostrarProductoProveedor", urlPatterns = {"/controlador/MostrarProductoProveedor"})
public class MostrarProductoProveedorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private DAOProducto daoProducto= null;
	private DAOProveedor daoProveedor= null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException{

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

		try {

			PrintWriter out = response.getWriter();
			response.setContentType("application/json");

			List<Producto> productos = daoProducto.listar();
			List<Proveedor> proveedores = daoProveedor.listar();

			JsonArray datos = new JsonArray();

			JsonArray array =null;
			for (Producto p: productos)
			{
				for (Proveedor pr : proveedores) {
					array = new JsonArray();
					array.add(p.getId());
					array.add( p.getNombre());
					array.add(pr.getRun());
					array.add( pr.getNombre());
					boolean resultado = checkProveedor(p.getProveedor(), pr); 
					if (resultado)
						array.add("checked");
					else
						array.add("0");
					datos.add(array);
				}
			}

			JsonObject miembros = new JsonObject();
			miembros.addProperty("echo","1"); //important case-sensitive
			miembros.addProperty("recordsTotal", productos.size()*proveedores.size());
			miembros.addProperty("recordsFiltered",productos.size()*proveedores.size());

			miembros.add("data", datos);
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String json2 = gson.toJson(miembros);
			out.print(json2);


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private boolean checkProveedor(List<Proveedor> lstProveedor, Proveedor proveedor) {

		for (Proveedor p : lstProveedor)
			if (p.getRun() == proveedor.getRun())
				return true;

		return false;
	}

}
