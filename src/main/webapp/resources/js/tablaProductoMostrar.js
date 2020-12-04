jQuery(document).ready(function () {
                $('#listaProductoMostrar').dataTable( {
                 "bProcessing": false,
       			 "bServerSide": false,
                 ajax: {
                    url: "/sanmateo/controlador/ListarProducto",
                    type: "GET", 
                    contentType: "application/json; charset=utf-8",
           			dataType: 'json'
                }
              });
              
 });