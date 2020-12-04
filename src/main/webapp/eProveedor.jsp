<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Eliminar Producto</title>
<script src="resources/js/jquery-3.5.1.min.js"></script>
<script src="resources/js/jquery.validate.min.js"></script>
<script src="resources/js/jquery.mask.min.js"></script>
<script type="text/javascript">
jQuery(document).ready(function() {

	 $("#run").mask('00.000.000-0');	
	  $("#basic-form").validate({
	    rules: {
	      run: {
	        required: true,
	        number:true
	      }
	    }
	  });
});
</head>
<body>
<h2>Eliminar un Proveedor</h2>
<form id="basic-form" action="/sanmateo/controlador/EliminarProveedor" method="GET">
		<table>
			<tr>
				<td>Run:</td>
				<td>
					<input id= "run" type="text" name="run" >
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input class="submit" type="submit" value="Eliminar"></td>
			</tr>
		</table>
	</form>

</body>
</html>