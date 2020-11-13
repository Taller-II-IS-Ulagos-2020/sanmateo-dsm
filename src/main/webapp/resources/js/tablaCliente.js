  jQuery(document).ready(function () {
                $('#listaCliente').dataTable( {
                 "bProcessing": false,
       			 "bServerSide": false,
                 ajax: {
                    url: "/sanmateo/controlador/ListarCliente",
                    type: "GET", 
                    contentType: "application/json; charset=utf-8",
           			dataType: 'json'
                }
              });
              
 });