jQuery.validator.addMethod("checkUnique", function(value, element) {
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", "checkAssignId?application_id="+value, false ); // false for synchronous request
    xmlHttp.send( null );
    if(xmlHttp.responseText=="true") {
        document.getElementById("viewEmail").innerHTML = "";
    }
    return xmlHttp.responseText=="false";
});
jQuery.validator.addMethod("getEmail", function(value, element) {
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", "getEmail?application_id="+value, false ); // false for synchronous request
    xmlHttp.send( null );
    document.getElementById("viewEmail").innerHTML="";
    document.getElementById("viewEmail").innerHTML+=xmlHttp.responseText;

    return true;
});
jQuery.validator.addMethod("checksch", function(value, element) {
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", "checksch?application_id="+value, false ); // false for synchronous request
    xmlHttp.send( null );

    return xmlHttp.responseText=="false";
});
jQuery.validator.addMethod("checkint", function(value, element) {
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", "checkint?application_id="+value, false ); // false for synchronous request
    xmlHttp.send( null );

    return xmlHttp.responseText=="false";
});

$(function() {

    $("form[id='contact']").validate({
        rules: {
            application_id: {
                required: true,
                minlength: 8,
                maxlength: 8,
                number: true,
                checkUnique: true,
                checksch :true,
                checkint:true,
                getEmail: true

            },
            result_interview: {
                required: true,
                number: true

            }

        },
        messages: {

            application_id: {
                required: "enter valid id",
                minlength: "enter valid id",
                maxlength: "enter valid id",
                number: "enter valid id",
                checkUnique: "not assigned",
                checksch:"not assigned for your school",
                checkint:"already interviewed"
            },
            result_interview: {
                required: "mark required",
                number: "input valid mark"

            }
        },
        submitHandler: function(form) {
            form.submit();
        }
    });
});
