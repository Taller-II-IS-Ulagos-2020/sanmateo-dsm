jQuery(document).ready(function() {
	
 $("#run").mask('00.000.000-0');	
	
  $("#basic-form").validate({
	
    rules: {
   
      run: {
        required: true,
 	    minlength:12,
        maxlength:12
      },
    
      nombre : {
        required: true,
 	    minlength:3,
       
      },

	 telefono : {
        required: true,
        minlength:9,
		maxlength:9,
		number:true
      },

	 direccion : {
        required: true,
        minlength:12,
      },
    }
  });

});/**
 * 
 */