jQuery.validator.addMethod("checkDrop", function(value, element) {

    if(value!="NO"&& value!="empty"&& value!="0"){
        return true;
    }
    else return false;
});

jQuery.validator.addMethod("checkNic", function(value, element) {
 if(/^\d+$/.test(value.substr(0,10)) && value[value.length-1] in["v","V"]){
     return true;
 }
 else return false;
});


$(function() {

    $("form[id='contact']").validate({
        rules: {

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
            },
            NIC:{
               required:true,
                minlength: 10,
                maxlength: 10,
               checkNic:true
            }




        },

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
            religion:"select religion",
            NIC:"enter Valid Nic"
        },

        submitHandler: function(form) {
            form.submit();
        }
    });
});