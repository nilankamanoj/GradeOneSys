<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE HTML>
<html>
<head>
    <title>Interview</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="${contextPath}/resources/assets/css/main.css" />
    <link rel="stylesheet" href="${contextPath}/resources/assets/css/customize.css" />
    <script src="${contextPath}/resources/assets/js/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.17.0/dist/jquery.validate.js"></script>
    <script src="${contextPath}/resources/validator/validateInt.js"></script>
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
            <form:form id="contact" method="POST" modelAttribute="interviewee" class="form-signin">
                <h2 class="form-signin-heading">Add Interview Marks</h2>
                <span>${message}</span>

                <spring:bind path = "application_id">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="application_id" class="form-control" placeholder="application id"
                                    autofocus="true"></form:input>
                        <form:errors path="application_id"></form:errors>
                    </div>
                </spring:bind>
                <spring:bind path = "result_interview">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="result_interview" class="form-control" placeholder="Mark"
                                    autofocus="true"></form:input>
                        <form:errors path="result_interview"></form:errors>
                    </div>
                </spring:bind>
                <button class="button special" type="submit">Submit</button>

            </form:form>
        </div>

    </section>
    </br>
    <center>
        <h2>This is the view for confirming email</h2>
    </center>
    <div id="viewEmail" class="customBox">

    </div>
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




