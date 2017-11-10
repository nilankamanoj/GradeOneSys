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
            // The key name on the left side is the name attribute
            // of an input field. Validation rules are defined
            // on the right side
            first_name: "required",
            second_name: "required",
            initials:"required",
            div_grama:"required",
            Id:{
                required: true,
                minlength: 8,
                maxlength: 8,
                number: true

            },
            dob:{
                required:true,
                date:true
            },
            gender:{
                checkDrop:true
            },
            district:{
                checkDrop:true
            },
            div_sec:{
                checkDrop:true
            },
            religion:{
                checkDrop:true
            }




        },
        // Specify validation error messages
        messages: {
            Id:"Enter Valid Id",
            first_name: "enter first name",
            second_name: "enter second name",
            dob:"Enter valid DOB",
            initials:"enter initials",
            div_grama:"enter grama division",
            gender:"select gender",
            district:"select district",
            div_sec:"select division",
            religion:"select religion"
        },
        // Make sure the form is submitted to the destination defined
        // in the "action" attribute of the form when valid
        submitHandler: function(form) {
            form.submit();
        }
    });
});