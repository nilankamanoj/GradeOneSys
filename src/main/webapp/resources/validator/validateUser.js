jQuery.validator.addMethod("checkDrop", function(value, element) {
    // allow any non-whitespace characters as the host part
    if(value!="NO"&& value!="empty"&& value!="0"){
        return true;
    }
    else return false;
});
$(function() {

    $("form[id='contact']").validate({
        // Specify validation rules
        rules: {
            username:{
                required:true,
                minlength:6
            },
            password:{
                required:true,
                minlength:8
            },

            passwordConfirm:{
                required:true,
                equalTo: "#password"
            },

            occupation:{
                required:true,
                checkDrop:true
            }



        },
        // Specify validation error messages
        messages: {
            username:"user name too short",
            password:"enter at least 8 chars",
            passwordConfirm:"passwords dont match",
            occupation:"select occupation"

        },
        // Make sure the form is submitted to the destination defined
        // in the "action" attribute of the form when valid
        submitHandler: function(form) {
            form.submit();
        }
    });
});