jQuery.validator.addMethod("checkAvailable", function(value, element) {
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", "checkAppId?application_id="+value, false ); // false for synchronous request
    xmlHttp.send( null );
    return xmlHttp.responseText=="false";
});
jQuery.validator.addMethod("checkNic", function(value, element) {
    if(/^\d+$/.test(value.substr(0,9)) && (value.includes("v") || value.includes("V"))){
        return true;
    }
    else return false;
});
jQuery.validator.addMethod("checkNIC", function(value, element) {
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", "checkNIC?NIC="+value, false ); // false for synchronous request
    xmlHttp.send( null );
    return xmlHttp.responseText=="false";
});

jQuery.validator.addMethod("checkUnique", function(value, element) {
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", "checkAssignId?application_id="+value, false ); // false for synchronous request
    xmlHttp.send( null );
    return xmlHttp.responseText=="true";
});
jQuery.validator.addMethod("checkSchool", function(value, element) {
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", "checkSchId?sch_id="+value, false ); // false for synchronous request
    xmlHttp.send( null );
    return xmlHttp.responseText=="false";
});


$(function() {

    $("form[id='contact']").validate({
        rules: {
            application_id:{
                required: true,
                minlength: 8,
                maxlength: 8,
                number: true,
                checkAvailable:true,
                checkUnique:true
            },

            nic:{
                required:true,
                minlength: 10,
                maxlength: 10,
                checkNic:true,
                checkNIC:true
            },

            sch_id1:{
                required : true,
                minlength: 8,
                maxlength: 8,
                number: true,
                checkSchool:true
            },
            distance1:{
                required : true,
                number: true
            },


        },

        messages: {

            application_id:{
                required: "enter valid id",
                minlength: "enter valid id",
                maxlength: "enter valid id",
                number: "enter valid id",
                checkAvailable: "not yet entered to db",
                checkUnique:"already assigned"
            },
            nic:{
                required:"ender valid nic",
                minlength: "ender valid nic",
                maxlength:"ender valid nic",
                checkNic:"ender valid nic",
                checkNIC:"not yet entered to db"
            },
            sch_id1:{
                required:"enter at least one",
                minlength: "enter valid id",
                maxlength: "enter valid id",
                number: "enter valid id",
                checkSchool: "enter listed one"
            },
            distance1:{
                required:"enter at least one",
                number: "enter valid distance"
            }


        },

        submitHandler: function(form) {
            form.submit();
        }
    });
});