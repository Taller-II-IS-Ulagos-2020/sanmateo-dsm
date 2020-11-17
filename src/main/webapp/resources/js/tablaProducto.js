var tabla;
var i = 0;

function getValor(sel){
 
 	var id= sel.id;
 	var newId = id.split('_');
	var str="";
    var tableName = $("#listaProducto").DataTable()
    tableName.rows().every(function(){
        	var idProducto = this.data()[0];
	    	var selector=JSON.parse(JSON.stringify(this.data()[3]));
	    	var row = $(this.node());
	    	var ide=newId[0]+'_' + row.index();
	    	var val = $("#"+ ide).val();
	    	
	    	selector.forEach(function(obj) { 
	    	
		    	if (val == obj.run)
		    		str = str + idProducto + "-" + 	obj.run + "-" + obj.nombre + "|";
		    	else
		    		str = str + idProducto + "-" + 	'null' + "-" + 'null' + "|";
	    		
	    	});

	});
	$("#dtTable").val(str);
}      

 jQuery(document).ready(function () {
         tabla=$('#listaProducto').dataTable( {
                 "bProcessing": false,
       			 "bServerSide": false,
                 ajax: {
                    url: "/sanmateo/controlador/ComprarProducto",
                    type: "GET", 
                    contentType: "application/json; charset=utf-8",
           			dataType: 'json'
                },
                columnDefs:[
      				 {targets:[3], render : function(data){return createSelect(data);}}           
                   ]
              });         
 });
 
$(document).on("submit", $(this), function (e) {

});
 
function createSelect(selItem){
  
    var id = 'cliente_' + i;
  	var sel = '<select id="' + id + '" onChange="getValor(this)"><option>Seleccione Cliente</option>' ;
  	
  	$.each(selItem, function(i, selItem){
 
  		if(typeof selItem['selected'] != 'undefined')
  			sel += "<option selected value = '"+selItem.run+"' >" + selItem.nombre + "</option>";
  		else
    		sel += "<option  value = '"+selItem.run+"' >" + selItem.nombre + "</option>";
    });
     sel +="</select>";
     i++;
    return sel;
}



