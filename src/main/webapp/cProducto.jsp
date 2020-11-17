<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Comprar Producto Cliente</title>
<script src="resources/js/jquery-3.5.1.min.js"></script>
<script src="resources/js/datatables.min.js"></script>
<script src="resources/js/tablaProducto.js"></script>
<link rel="stylesheet" href="resources/css/datatables.min.css">

</head>
<body>
<h2>Comprar un Producto</h2>


<form id="basic-form" action="/sanmateo/controlador/ComprarProducto" method="POST">
<input class="submit" type="submit" id="btnGuardar" value="Guardar" name="btnGuardar">
 <table id="listaProducto">
             <thead>
                <tr>
                    <th>Id Producto</th>
                   <th>Nombre Producto</th>
                    <th>Precio Unitario</th> 
                    <th>Comprador</th>                        
                </tr>
              </thead>
         </table>
 <input type="hidden" id="dtTable" name="dtTable">
</form>
</body>
</html>