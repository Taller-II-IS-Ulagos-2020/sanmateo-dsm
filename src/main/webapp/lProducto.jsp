<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar Productos</title>
<script src="resources/js/jquery-3.5.1.min.js"></script>
<script src="resources/js/datatables.min.js"></script>
<script src="resources/js/tablaProductoMostrar.js"></script>
<link rel="stylesheet" href="resources/css/datatables.min.css">
</head>
<body>
<h2>Listar Productos</h2>
          
        <table id="listaProductoMostrar">
             <thead>
                <tr>
                    <th>Id</th>
                   <th>Nombre</th>      
                   <th>Precio</th>                             
                </tr>
              </thead>
         </table>
          
</body>
</html>