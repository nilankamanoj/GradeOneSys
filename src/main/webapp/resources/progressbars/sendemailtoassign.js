jQuery(document).ready(function() {

  function jsHello(box2) {


    setTimeout(function () {
      var box=100-box2

      $('.progress-bar').css('width', box + '%');
      $('.current-value').text(box + '%');
      if (box2 == 0) return;




      jsHello(100-getPercentage());


      sendEmails();
      if(document.getElementById("confirm").value =="CONFIRM" && getPercentage()==0){
        document.getElementById("status").innerHTML="STARTING SENDING..";
        document.getElementById("result").style.disply ='none';

      }
      else if( getPercentage()>0 && getPercentage()<100){
        document.getElementById("status").innerHTML="SENDING EMAILS......";
        document.getElementById("confirm").style.display = 'none';

      }
      else if(getPercentage()==100){
        document.getElementById("status").innerHTML="COMPLETED";

        var str=getResults();
        var partsOfStr = str.split(',');

        document.getElementById("result").innerHTML="<div class = 'results'>total ="+partsOfStr[0]+"<br>"+"sent emails ="+partsOfStr[1]+"<br>"+"Failed ="+partsOfStr[2]+"</div>";


      }



    }, 1000);
  }

  jsHello(100);
});

function getPercentage() {

  var xmlHttp = new XMLHttpRequest();
  xmlHttp.open("GET", "checkPercentage", false); // false for synchronous request
  xmlHttp.send(null);
  return parseInt(xmlHttp.responseText);


}

function getResults() {
  var xmlHttp = new XMLHttpRequest();
  xmlHttp.open("GET", "checkResults", false); // false for synchronous request
  xmlHttp.send(null);
  return xmlHttp.responseText;

}


function sendEmails() {

  if(document.getElementById("confirm").value!="CONFIRM" ){

  }
  else {

    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open("GET", "getPercentage", true); // false for synchronous request
    xmlHttp.send(null);


  }

}
