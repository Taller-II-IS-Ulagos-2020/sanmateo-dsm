function getValores(){
	var str ="";
	var tableName = $("#listaProductoProveedor").dataTable()
	$("input:checked", tableName.fnGetNodes()).each(function(){
		var id = $(this).attr('id');
		if($("#" + id).is(':checked')) {  
            str = str + id + "|";
        }
	});
	$("#dtTable").val(str);
}

$(document).on("submit", $(this), function (e) {

});

jQuery(document).ready(function () {
         tabla=$('#listaProductoProveedor').dataTable( {
                 "bProcessing": false,
       			 "bServerSide": false,
                 ajax: {
                    url: "/sanmateo/controlador/MostrarProductoProveedor",
                    type: "GET", 
                    contentType: "application/json; charset=utf-8",
           			dataType: 'json'
                },
                columns: [
				            {render: function ( data, type, row ) {
				                    return row[0];
				            } },
				            {render: function ( data, type, row ) {
				           
				                     return row[1];
				            } },
				              {render: function ( data, type, row ) {
				                     return row[2];
				            } },
				              {render: function ( data, type, row ) {
				                     return row[3];
				            } },
				             {render: function (data, type, row){
            					 return createCheckBox(row);	
				            } }
				          ]
                
          });         
 });
 
 
 function createCheckBox(row){
  
  	var idCheck = row[0] + "_" + row[2];
  	var checkbox = '';
  	if (row[4] == 'checked')
  		 checkbox = "<input type='checkbox' checked name='" + idCheck + "' id='" + idCheck + "'  value='text'  onclick='getValores();'>";
  	else
  		 checkbox = "<input type='checkbox' name='" + idCheck + "' id='" + idCheck + "'  value='text'  onclick='getValores();'>";
    return checkbox;
}
 