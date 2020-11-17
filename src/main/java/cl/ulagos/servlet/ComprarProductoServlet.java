package cl.ulagos.servlet;

import java.io.PrintWriter;
import java.util.List;
import java.util.regex.Pattern;

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
import cl.ulagos.dao.DAOProducto;
import cl.ulagos.modelo.Cliente;
import cl.ulagos.modelo.Producto;


@WebServlet(name="ComprarProducto", urlPatterns = {"/controlador/ComprarProducto"})
public class ComprarProductoServlet extends HttpServlet {

	private static final long serialVersionUID = 3522425561689961750L;
	private DAOProducto daoProducto= null;
	private DAOCliente daoCliente= null;


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

				List<Cliente> clientes = daoCliente.listar();
				JsonArray selectorCliente = new JsonArray();
				for (Cliente c: clientes)
				{
					JsonObject objetoCliente = new JsonObject();
					objetoCliente.addProperty("run",c.getRun());
					objetoCliente.addProperty("nombre",c.getNombre());
					if (p.getCliente() != null && p.getCliente().getRun() ==c.getRun())
						objetoCliente.addProperty("selected",true);
					selectorCliente.add(objetoCliente);
				}
				fila.add(selectorCliente);
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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException{
		
		String data = request.getParameter("dtTable");
		data = data.substring(0, data.length()-1);
		String compraCliente[] = data.split(Pattern.quote("|"));
		for (String cC : compraCliente) {
			
			Long idProducto = Long.parseLong(cC.split(Pattern.quote("-"))[0]);
			String runStr = cC.split(Pattern.quote("-"))[1];
			String nombreStr = cC.split(Pattern.quote("-"))[2];
			
			if (!runStr.equals("null")) {
				int run = Integer.parseInt(runStr);
				Cliente cliente = new Cliente(run,nombreStr);
				Producto producto = new Producto();
				producto.setId(idProducto);
				
				try {
					Cliente clienteBD = daoCliente.buscar(cliente);
					Producto productoBD = daoProducto.buscar(producto);
					productoBD.setCliente(clienteBD);
					daoProducto.modificar(productoBD);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

