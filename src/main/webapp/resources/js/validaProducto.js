jQuery(document).ready(function() {
	
  $("#basic-form").validate({
	
    rules: {
    
    
      nombre: {
        required: true
      },
    
      precio : {
        required: true,
        number:true
      }
    }
  });

});