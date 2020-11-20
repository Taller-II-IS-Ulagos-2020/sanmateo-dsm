<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*, java.io.*, java.net.*, java.util.jar.*, java.sql.Timestamp, java.text.*"%>
<html>
<head>
<script src="resources/js/jquery-3.5.1.min.js"></script>
<script src="resources/js/menu.js"></script>
<link rel="stylesheet" href="resources/css/menu.css">
</head>
<%
	ServletContext app = getServletConfig().getServletContext();
	InputStream inputStream = application.getResourceAsStream("/META-INF/MANIFEST.MF");
	Manifest manifest = new Manifest(inputStream);
	Attributes atts = manifest.getMainAttributes();
	String values[] = atts.getValue("Implementation-Version").split("\\-");
	long val = Long.parseLong(values[2]);
	Timestamp ts = new Timestamp(val);
	DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	String date = df.format(new Date(ts.getTime()));
%>
<body>
	<table>
		<tr>
			<td>
				<ul class="menu">
					<li><a id="Home" href="index.jsp">Home</a></li>
					<li><a href="#">Cliente</a>
						<ul>
							<li><a id="idICliente" href="iCliente.jsp" class="new">Ingresar Cliente</a></li>							
							<li><a id="idECliente" href="eCliente.jsp" class="new">Eliminar Cliente</a></li>	
							<li><a id="idACliente" href="aCliente.jsp" class="new">Actualizar Cliente</a></li>
							<li><a id="idLCliente" href="lCliente.jsp" class="new">Listar Cliente</a></li>
						</ul>
					</li>
					
						<li><a href="#">Producto</a>

						<ul>
							<li><a id="idIProducto" href="iProducto.jsp" class="new">Ingresar Producto</a></li>
							<li><a id="idEProducto" href="eProducto.jsp" class="new">Eliminar Producto</a></li>
							<li><a id="idAProducto" href="aProducto.jsp" class="new">Actualizar Producto</a></li>
							<li><a id="idLProducto" href="lProducto.jsp" class="new">Listar Producto</a></li>
						</ul>
					</li>
					
					<li><a href="#">Comprar</a>

						<ul>
							<li><a id="idCProducto" href="cProducto.jsp" class="new">Producto</a></li>
							<li><a id="ventas" href="/sanmateo/controlador/ResumenVenta" class="new">Ventas</a></li>
	
						</ul>
					</li>

				</ul>
			</td>
		</tr>
		<tr>
			<td><iframe style="border: none;" name="someFrame"
					id="someFrame" width="1300" height="550">Hola Mundo</iframe></td>
		</tr>
	</table>
	<table>
		<tr>
			<td>SanMateo versión: <b><%=values[1]%></b>, compilada el <b><%=date%></b>.
			</td>
		</tr>
	</table>
</body>
</html>  
