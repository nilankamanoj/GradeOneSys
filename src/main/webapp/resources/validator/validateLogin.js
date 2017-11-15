
$(function() {

  $("form[id='form-sign-in']").validate({
    // Specify validation rules
    rules: {
      username:{
        required:true,
        minlength:6
      },
      password:{
        required:true,
        minlength:8
      }




    },
    // Specify validation error messages
    messages: {
      username:"enter vallid username",
      password:"enter valid password"


    },
    // Make sure the form is submitted to the destination defined
    // in the "action" attribute of the form when valid
    submitHandler: function(form) {
      form.submit();
    }
  });
});
