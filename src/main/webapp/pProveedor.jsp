<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Asociar Producto-Proveedor</title>
<script src="resources/js/jquery-3.5.1.min.js"></script>
<script src="resources/js/datatables.min.js"></script>
<script src="resources/js/dataTables.select.min.js"></script>
<script src="resources/js/tablaProductoProveedor.js"></script>
<link rel="stylesheet" href="resources/css/datatables.min.css">
</head>
<body>
<form id="basic-form" action="/sanmateo/controlador/AsociarProductoProveedor" method="POST">
<input class="submit" type="submit" id="btnGuardar" value="Guardar" name="btnGuardar">
 <table id="listaProductoProveedor">
             <thead>
                <tr>
                    <th>Id Producto</th>
                    <th>Nombre Producto</th>
                   <th>Run Proveedor</th>  
                   <th>Nombre Proveedor</th>
                   <th>Seleccion</th>              
                </tr>
              </thead>
         </table>
 <input type="hidden" id="dtTable" name="dtTable">
</form>
</body>
</html>