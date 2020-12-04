<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ingresar Producto</title>
<script src="resources/js/jquery-3.5.1.min.js"></script>
<script src="resources/js/jquery.validate.min.js"></script>
<script src="resources/js/jquery.mask.min.js"></script>
<script src="resources/js/validaProducto.js"></script>
</head>
<body>

<h2>Ingresar un Nuevo Producto</h2>
	<form id="basic-form" name="basic-form" action="/sanmateo/controlador/IngresarProducto" method="GET">
		<table>
			<tr>
				<td>Nombre:</td>
				<td>
					<input id= "nombre" type="text" name="nombre" >
				</td>
			</tr>
			<tr>
				<td>Precio:</td>
				<td><input type="text" id="precio" name="precio"></td>
			</tr>
			<tr>
				<td></td>
				<td><input class="submit" type="submit" value="Ingresar"></td>
			</tr>
		</table>
	</form>
</body>
</html>