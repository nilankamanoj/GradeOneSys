<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE HTML>
<html>
<head>
    <title>Add Past Pupil</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="${contextPath}/resources/assets/css/main.css" />
    <link rel="stylesheet" href="${contextPath}/resources/assets/css/customize.css" />
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
            <form:form id="contact" method="POST" modelAttribute="pastPupilForm" class="form-signin">
                <h2 class="form-signin-heading">Add past pupil details</h2>

                <span>${message}</span>

                <spring:bind path = "id">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="id" class="form-control" placeholder="NIC No."
                                    autofocus="true"></form:input>
                        <form:errors path="id"></form:errors>
                    </div>
                </spring:bind>

                <spring:bind path = "school_id">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="school_id" class="form-control" placeholder="School ID"
                                    autofocus="true"></form:input>
                        <form:errors path="school_id"></form:errors>
                    </div>
                </spring:bind>

                <spring:bind path = "student_id">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="student_id" class="form-control" placeholder="Student ID No."
                                    autofocus="true"></form:input>
                        <form:errors path="student_id"></form:errors>
                    </div>
                </spring:bind>

                <spring:bind path = "no_of_classes">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="no_of_classes" class="form-control" placeholder="No. of Classes"
                                    autofocus="true"></form:input>
                        <form:errors path="no_of_classes"></form:errors>
                    </div>
                </spring:bind>

                <spring:bind path = "period">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="period" class="form-control" placeholder="Period(From-Two)"
                                    autofocus="true"></form:input>
                        <form:errors path="period"></form:errors>
                    </div>
                </spring:bind>

                <spring:bind path = "past_pupil_member_id">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="past_pupil_member_id" class="form-control" placeholder="Past Pupil Membership ID No."
                                    autofocus="true"></form:input>
                        <form:errors path="past_pupil_member_id"></form:errors>
                    </div>
                </spring:bind>

                <spring:bind path = "achievements">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="achievements" class="form-control" placeholder="Achievements"
                                    autofocus="true"></form:input>
                        <form:errors path="achievements"></form:errors>
                    </div>
                </spring:bind>


                <button class="button special" type="submit">Submit</button>
            </form:form>

        </div>
    </section>
        <footer id="footer">
            <ul class="copyright">
                <li>Grade One Evaluating System - Ministry Of Education</li>
            </ul>
        </footer>
</div>
<script src="${contextPath}/resources/assets/js/jquery.min.js"></script>
<script src="${contextPath}/resources/assets/js/jquery.dropotron.min.js"></script>
<script src="${contextPath}/resources/assets/js/jquery.scrolly.min.js"></script>
<script src="${contextPath}/resources/assets/js/jquery.scrollgress.min.js"></script>
<script src="${contextPath}/resources/assets/js/skel.min.js"></script>
<script src="${contextPath}/resources/assets/js/util.js"></script>
<script src="${contextPath}/resources/assets/js/main.js"></script>

</body>
</html>



