jQuery.validator.addMethod("checkDrop", function(value, element) {
    // allow any non-whitespace characters as the host part
    if(value!="NO"&& value!="empty"&& value!="0"){
        return true;
    }
    else return false;


});
jQuery.validator.addMethod("checkSchool", function(value, element) {
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", "checkSchId?sch_id="+value, false ); // false for synchronous request
    xmlHttp.send( null );
    return xmlHttp.responseText=="true";
});


$(function() {

    $("form[id='contact']").validate({

        rules: {
            sch_id:{
                required:true,
                minlength:8,
                maxlength:8,
                digits: true,
                checkSchool:true
            },

            name:{
                required:true,
                minlength:3
            },

            division:{
                required:true,
                minlength:3
            },

            eligible_count:{
                required:true,
                minlength:2,
                maxlength:3,
                digits:true

            },
            province:{
                required:true,
                checkDrop:true

            },

            district:{
                required:true,
                checkDrop:true

            }







        },
        // Specify validation error messages
        messages: {
            sch_id:{
                required:"enter valid id",
                minlength:"enter valid id",
                maxlength:"enter valid id",
                digits: "enter valid id",
                checkSchool:"enter unique id"
            },
            name:"enter valid name",
            division:"enter valid division",
            eligible_count:"enter valid count",
            province:"select province",
            district:"select district"


        },
        // Make sure the form is submitted to the destination defined
        // in the "action" attribute of the form when valid
        submitHandler: function(form) {
            form.submit();
        }
    });
});