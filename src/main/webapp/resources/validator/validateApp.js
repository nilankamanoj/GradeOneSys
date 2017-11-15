jQuery.validator.addMethod("checkDrop", function(value, element) {

  if(value!="NO"&& value!="empty"&& value!="0"){
    return true;
  }
  else return false;
});

jQuery.validator.addMethod("checkUnique", function(value, element) {
  var xmlHttp = new XMLHttpRequest();
  xmlHttp.open( "GET", "checkAppId?application_id="+value, false ); // false for synchronous request
  xmlHttp.send( null );
  return xmlHttp.responseText=="true";
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
        number: true,
        checkUnique:true

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





    },

    messages: {
      Id:"Enter Valid/unused Id",
      first_name: "enter first name",
      second_name: "enter second name",
      dob:"Enter valid DOB",
      initials:"enter initials",
      div_grama:"enter grama division",
      gender:"select gender",
      district:"select district",
      div_sec:"select division",
      religion:"select religion",

    },

    submitHandler: function(form) {
      form.submit();
    }
  });
});
