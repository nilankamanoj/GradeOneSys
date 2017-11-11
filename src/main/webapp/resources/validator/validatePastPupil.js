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

jQuery.validator.addMethod("checkPeriod", function(value, element) {
    if(value.includes("-") && (value.split("-")).length==2 && (value.split("-"))[0].length==4 && (value.split("-"))[1].length==4){
        return true;
    }

    else return false;
});
jQuery.validator.addMethod("checkUnique", function(value, element) {

    if(!ids.includes(value.toLowerCase())){
        return true;
    }
    else return false;
});

$(function() {

    $("form[id='contact']").validate({

        rules: {

            id:{
                required:true,
                minlength: 10,
                maxlength: 10,
                checkNic:true,
                checkUnique:true
            },
            school_id:{
                required:true,
                minlength: 8,
                maxlength: 8

            },
            student_id:{
                required:true,
                minlength: 8,
                maxlength: 8,
                digits: true

            },
            no_of_classes:{
                required:true,
                digits: true
            },
            period:{
                required:true,
                checkPeriod:true

            },
            past_pupil_member_id:{
                digits:true,
                minlength: 8,
                maxlength: 8

            }





        },
        // Specify validation error messages
        messages: {
            id:"enter valid/unused nic",
            school_id:"enter valid school",
            student_id:"enter valid id",
            no_of_classes:"enter valid count",
            period:"enter (start-end)",
            past_pupil_member_id:"enter valid id"

        },
        // Make sure the form is submitted to the destination defined
        // in the "action" attribute of the form when valid
        submitHandler: function(form) {
            form.submit();
        }
    });
});