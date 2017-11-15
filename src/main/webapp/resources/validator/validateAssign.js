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
  return (xmlHttp.responseText=="false"||value.length<8);
});
jQuery.validator.addMethod("check2", function(value, element) {
  var sch_id1 =document.getElementById("sch_id1").value;
  if((value==sch_id1)&&value.length==8) {
    return false;
  }
  else return true;
});
jQuery.validator.addMethod("check3", function(value, element) {
  var sch_id1 =document.getElementById("sch_id1").value;
  var sch_id2 =document.getElementById("sch_id2").value;
  if((value==sch_id1||value==sch_id2)&&value.length==8) {
    return false;
  }
  else return true;
});
jQuery.validator.addMethod("check4", function(value, element) {
  var sch_id1 =document.getElementById("sch_id1").value;
  var sch_id2 =document.getElementById("sch_id2").value;
  var sch_id3 =document.getElementById("sch_id3").value;
  if((value==sch_id1||value==sch_id2||value==sch_id3)&&value.length==8) {
    return false;
  }
  else return true;
});
jQuery.validator.addMethod("check5", function(value, element) {
  var sch_id1 =document.getElementById("sch_id1").value;
  var sch_id2 =document.getElementById("sch_id2").value;
  var sch_id3 =document.getElementById("sch_id3").value;
  var sch_id4 =document.getElementById("sch_id4").value;
  if((value==sch_id1||value==sch_id2||value==sch_id3||value==sch_id4)&&value.length==8) {
    return false;
  }
  else return true;
});
jQuery.validator.addMethod("dis2", function(value, element) {
  var sch_id2 =document.getElementById("sch_id2").value;
  if(sch_id2.length==8 && value.length==0) {
    return false;
  }
  else return true;
});
jQuery.validator.addMethod("dis3", function(value, element) {
  var sch_id3 =document.getElementById("sch_id3").value;
  if(sch_id3.length==8 && value.length==0) {
    return false;
  }
  else return true;
});
jQuery.validator.addMethod("dis4", function(value, element) {
  var sch_id4 =document.getElementById("sch_id4").value;
  if(sch_id4.length==8 && value.length==0) {
    return false;
  }
  else return true;
});
jQuery.validator.addMethod("dis5", function(value, element) {
  var sch_id5 =document.getElementById("sch_id5").value;
  if(sch_id5.length==8 && value.length==0) {
    return false;
  }
  else return true;
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
      sch_id2:{

        minlength: 8,
        maxlength: 8,
        number: true,
        check2:true,
        checkSchool:true
      },
      distance2:{
        dis2:true,
        number: true
      },
      sch_id3:{

        minlength: 8,
        maxlength: 8,
        number: true,
        check3:true,
        checkSchool:true
      },
      distance3:{
        dis3:true,
        number: true
      },
      sch_id4:{

        minlength: 8,
        maxlength: 8,
        number: true,
        check4:true,
        checkSchool:true
      },
      distance4:{
        dis4:true,
        number: true
      },
      sch_id5:{

        minlength: 8,
        maxlength: 8,
        number: true,
        check5:true,
        checkSchool:true
      },
      distance5:{
        dis5:true,
        number: true
      }


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
      },
      sch_id2:{

        minlength: "enter valid id",
        maxlength: "enter valid id",
        number: "enter valid id",
        check2: "dupplicates in the form",
        checkSchool: "enter listed one"
      },
      distance2:{
        dis2:"enter distance",
        number: "enter valid distance"
      },
      sch_id3:{

        minlength: "enter valid id",
        maxlength: "enter valid id",
        number: "enter valid id",
        check3: "dupplicates in the form",
        checkSchool: "enter listed one"
      },
      distance3:{
        dis3:"enter distance",
        number: "enter valid distance"
      },
      sch_id4:{

        minlength: "enter valid id",
        maxlength: "enter valid id",
        number: "enter valid id",
        check4: "dupplicates in the form",
        checkSchool: "enter listed one"
      },
      distance4:{
        dis4:"enter distance",
        number: "enter valid distance"
      },
      sch_id5:{

        minlength: "enter valid id",
        maxlength: "enter valid id",
        number: "enter valid id",
        check5: "dupplicates in the form",
        checkSchool: "enter listed one"
      },
      distance5:{
        dis5:"enter distance",
        number: "enter valid distance"
      }

    },

    submitHandler: function(form) {
      form.submit();
    }
  });
});
