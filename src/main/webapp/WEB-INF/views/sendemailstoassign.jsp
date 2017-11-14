<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE HTML>
<html>
<head>
    <title>Send Email</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" type="text/css" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${contextPath}/resources/assets/css/main.css" />
    <link rel="stylesheet" href="${contextPath}/resources/assets/css/customize.css" />
    <script src="${contextPath}/resources/assets/js/jquery.min.js"></script>
    <script>
        var status ="no";
        jQuery(document).ready(function() {

            function jsHello(box2) {


                setTimeout(function () {
                    var box=100-box2

                    $('.progress-bar').css('width', box + '%');
                    $('.current-value').text(box + '%');
                    if (box2 == 0) return;




                    jsHello(100-getPercentage());


                        sendEmails();



                }, 500);
            }

            jsHello(100);
        });

        function getPercentage() {

                var xmlHttp = new XMLHttpRequest();
                xmlHttp.open("GET", "checkPercentage", false); // false for synchronous request
                xmlHttp.send(null);
                return parseInt(xmlHttp.responseText);


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




    </script>
</head>
<body class="index">
<div id="page-wrapper">
    ${nav}
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </c:if>
    <section id="banner">
        <div class="inner">
            <header>Send Emails TO Applicants</header>
<form:form id="contact" method="POST"  class="form-signin">
            ${button}

            ${progress}
    <input id="confirm" placeholder="CONFIRM">
</form:form>

        </div>
    </section>
    <footer id="footer">
        <ul class="copyright">
            <li><strong>Grade One Evaluating System - Ministry Of Education</strong></li>
        </ul>
        <img width="130px" height="auto" src="${contextPath}/resources/images/Aurora-logo.png" alt="">
    </footer>
</div>

<script src="${contextPath}/resources/assets/js/jquery.dropotron.min.js"></script>
<script src="${contextPath}/resources/assets/js/jquery.scrolly.min.js"></script>
<script src="${contextPath}/resources/assets/js/jquery.scrollgress.min.js"></script>
<script src="${contextPath}/resources/assets/js/skel.min.js"></script>
<script src="${contextPath}/resources/assets/js/util.js"></script>
<script src="${contextPath}/resources/assets/js/main.js"></script>

</body>
</html>




