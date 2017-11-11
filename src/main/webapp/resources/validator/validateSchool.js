jQuery.validator.addMethod("checkDrop", function(value, element) {
    // allow any non-whitespace characters as the host part
    if(value!="NO"&& value!="empty"&& value!="0"){
        return true;
    }
    else return false;


});
jQuery.validator.addMethod("checkUnique", function(value, element) {

    if(!ids.includes(value)){
        return true;
    }
    else return false;
});

$(function() {

    $("form[id='contact']").validate({

        rules: {
            sch_id:{
                required:true,
                minlength:8,
                maxlength:8,
                digits: true,
                checkUnique:true
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
            sch_id:"enter valid id",
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