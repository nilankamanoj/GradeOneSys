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
  var xmlHttp = new XMLHttpRequest();
  xmlHttp.open( "GET", "checkId?id="+value, false ); // false for synchronous request
  xmlHttp.send( null );
  return xmlHttp.responseText=="true";
});

jQuery.validator.addMethod("checkSchool", function(value, element) {
  var xmlHttp = new XMLHttpRequest();
  xmlHttp.open( "GET", "checkSchId?sch_id="+value, false ); // false for synchronous request
  xmlHttp.send( null );
  return xmlHttp.responseText=="false";
});

jQuery.validator.addMethod("checkSchStu", function(value, element) {
  var sch_id=document.getElementById("sch_id").value;
  var xmlHttp = new XMLHttpRequest();
  xmlHttp.open( "GET", "checkSchStuCombination?sch_id="+sch_id+"&stu_id="+value, false ); // false for synchronous request
  xmlHttp.send( null );
  return xmlHttp.responseText=="true";
});

jQuery.validator.addMethod("checkSchMem", function(value, element) {
  var sch_id=document.getElementById("sch_id").value;
  var xmlHttp = new XMLHttpRequest();
  xmlHttp.open( "GET", "checkSchMemCombination?sch_id="+sch_id+"&mem_id="+value, false ); // false for synchronous request
  xmlHttp.send( null );
  return xmlHttp.responseText=="true";
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
        maxlength: 8,
        checkSchool:true

      },
      student_id:{
        required:true,
        minlength: 8,
        maxlength: 8,
        digits: true,
        checkSchStu:true

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
        maxlength: 8,
        checkSchMem:true

      }


      


    },
    // Specify validation error messages
    messages: {
      id:"enter valid/unused nic",
      school_id:"enter valid school",
      student_id:{
        required:"enter valid id",
        minlength: "enter valid id",
        maxlength: "enter valid id",
        digits: "enter valid id",
        checkSchStu:"school/student pair used"

      },
      no_of_classes:"enter valid count",
      period:"enter (start-end)",
      past_pupil_member_id:{
        digits: "enter valid id",
        minlength: "enter valid id",
        maxlength: "enter valid id",
        checkSchMem:"school/member pair used"


      }

    },
    // Make sure the form is submitted to the destination defined
    // in the "action" attribute of the form when valid
    submitHandler: function(form) {
      form.submit();
    }
  });
});
