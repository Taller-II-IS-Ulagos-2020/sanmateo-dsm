<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<html>
<head>
<title>Ingresar un Cliente</title>
<script src="resources/js/jquery-3.5.1.min.js"></script>
<script src="resources/js/jquery.validate.min.js"></script>
<script src="resources/js/jquery.mask.min.js"></script>
<script src="resources/js/validaCliente.js"></script>
</head>
<body>

<h2>Ingresar un Nuevo Cliente</h2>
	<form id="basic-form" action="/sanmateo/controlador/IngresarCliente" method="GET">
		<table>
			<tr>
				<td>Run:</td>
				<td>
					<input id= "run" type="text" name="run" >
				</td>
			</tr>
			<tr>
				<td>Nombre:</td>
				<td><input type="text" name="nombre"></td>
			</tr>
			<tr>
				<td></td>
				<td><input class="submit" type="submit" value="Ingresar"></td>
			</tr>
		</table>
	</form>
</body>
</html>