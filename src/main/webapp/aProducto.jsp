<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Actualizar Producto</title>
<script src="resources/js/jquery-3.5.1.min.js"></script>
<script src="resources/js/jquery.validate.min.js"></script>
<script src="resources/js/jquery.mask.min.js"></script>
<script type="text/javascript">
jQuery(document).ready(function() {
	  $("#basic-form").validate({
	    rules: {
	      idProducto: {
	        required: true,
	        number:true
	      },
	      nombre: {
		        required: true
		      
		      },
		  precio: {
			        required: true,
			        number:true
		 }
	      
	    }
	  });
});

</script>
</head>
<body>
<h2>Actualizar un Producto</h2>
<form id="basic-form" action="/sanmateo/controlador/ActualizaProducto" method="GET">
		<table>
			<tr>
				<td>Id:</td>
				<td>
					<input id= "idProducto" type="text" name="idProducto" >
				</td>
			</tr>
			<tr>
				<td>Nombre:</td>
				<td><input type="text" name="nombre"></td>
			</tr>
			<tr>
				<td>Precio:</td>
				<td><input type="text" name="precio"></td>
			</tr>
			<tr>
				<td></td>
				<td><input class="submit" type="submit" value="Actualizar"></td>
			</tr>
		</table>
	</form>
</body>
</html>