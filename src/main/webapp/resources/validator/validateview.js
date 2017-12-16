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
$(function() {

  $("form[id='contact']").validate({
    rules: {
      Id: {
        required: true,
        minlength: 8,
        maxlength: 8,
        number: true,
        checkUnique: true,
        getEmail: true

      },
      mark: {
          required: true,
          number: true

      }

    },
    messages: {

      Id: {
        required: "enter valid id",
        minlength: "enter valid id",
        maxlength: "enter valid id",
        number: "enter valid id",
        checkUnique: "not assigned"
      },
        mark: {
            required: "mark required",
            number: "input valid mark"

        }
    },
    submitHandler: function(form) {
      form.submit();
    }
  });
});
