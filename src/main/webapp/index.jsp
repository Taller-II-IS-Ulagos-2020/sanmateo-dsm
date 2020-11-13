<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<script src="resources/js/jquery-3.5.1.min.js"></script>
<script src="resources/js/menu.js"></script>
<link rel="stylesheet" href="resources/css/menu.css">
</head>
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
</body>
</html>  