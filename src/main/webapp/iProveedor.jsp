<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ingresar Proveedor</title>
<script src="resources/js/jquery-3.5.1.min.js"></script>
<script src="resources/js/jquery.validate.min.js"></script>
<script src="resources/js/jquery.mask.min.js"></script>
<script src="resources/js/validaProveedor.js"></script>
</head>
<body>
<h2>Ingresar Proveedor</h2>
<form id="basic-form" name="basic-form" action="/sanmateo/controlador/IngresarProveedor" method="GET">
		<table>
			<tr>
				<td>Run:</td>
				<td>
					<input id= "run" type="text" name="run" >
				</td>
			</tr>
			<tr>
				<td>Nombre:</td>
				<td><input type="text" id="nombre" name="nombre"></td>
			</tr>
			<tr>
				<td>Teléfono:</td>
				<td><input type="text" id="telefono" name="telefono"></td>
			</tr>
			<tr>
				<td>Dirección:</td>
				<td><input type="text" id="direccion" name="direccion"></td>
			</tr>
			<tr>
				<td></td>
				<td><input class="submit" type="submit" value="Ingresar"></td>
			</tr>
		</table>
	</form>
</body>
</html>