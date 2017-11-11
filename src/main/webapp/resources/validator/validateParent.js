jQuery.validator.addMethod("checkDrop", function(value, element) {
    // allow any non-whitespace characters as the host part
    if(value!="NO"&& value!="empty"&& value!="0"){
        return true;
    }
    else return false;
});
jQuery.validator.addMethod("checkNic", function(value, element) {
    if(/^\d+$/.test(value.substr(0,9)) && (value.includes("v") || value.includes("V"))){
        return true;
    }
    else return false;
});

jQuery.validator.addMethod("checkEmail", function(value, element) {
    // allow any non-whitespace characters as the host part
    return this.optional( element ) || /^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@(?:\S{1,63})$/.test( value );
});
jQuery.validator.addMethod("checkTp", function(value, element) {
    if(/^\d+$/.test(value) && value[0]=="0"){
        return true;
    }
    else return false;
});
jQuery.validator.addMethod("checkUnique", function(value, element) {
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", "checkNIC?NIC="+value, false ); // false for synchronous request
    xmlHttp.send( null );
    return xmlHttp.responseText=="true";
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
            gender:{
                checkDrop:true
            },
            NIC:{
                required:true,
                minlength: 10,
                maxlength: 10,
                checkNic:true,
                checkUnique:true
            },
            email:{
                required:true,
                checkEmail:true
            },
            telephone_no:{
                required:true,
                minlength: 10,
                maxlength: 10,
                checkTp:true
            },
            occupation:{
                required:true
            }





        },
        // Specify validation error messages
        messages: {
            first_name: "enter first name",
            second_name: "enter second name",
            initials:"enter initials",
            gender:"select gender",
            NIC:"enter valid/unused Nic",
            email:"enter valid email",
            telephone_no:"enter valid TP",
            occupation:"enter an occupation"
        },
        // Make sure the form is submitted to the destination defined
        // in the "action" attribute of the form when valid
        submitHandler: function(form) {
            form.submit();
        }
    });
});