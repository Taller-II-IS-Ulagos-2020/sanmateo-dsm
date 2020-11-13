var tabla;
  
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
              
     $("#btnGuardar").click(function() {
      
   		tabla.rows().every(function(){
   		 alert(this.data());
		});
   	
   		
   		//$(dtTable).val(sData);
   		// $("#basic-form").submit(); 
	});
            
 });
 
 function createSelect(selItem){
  
    var sel = "<select><option>Seleccione Cliente</option>" ;
    sel += "<option  value = '"+selItem.run+"' >" + selItem.nombre + "</option>";
    sel +="</select>";
    return sel;
}



