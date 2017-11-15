
$(function() {

  $("form[id='contact']").validate({
    // Specify validation rules
    rules: {
      oldPass:{
        required:true,
        minlength:8
      },
      password:{
        required:true,
        minlength:8
      },

      passwordConfirm:{
        required:true,
        equalTo: "#password"
      }


    },
    // Specify validation error messages
    messages: {
      oldPass:"enter valid password",
      password:"enter at least 8 chars",
      passwordConfirm:"passwords dont match"

    },
    // Make sure the form is submitted to the destination defined
    // in the "action" attribute of the form when valid
    submitHandler: function(form) {
      form.submit();
    }
  });
});
