<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE HTML>
<html>
<head>
    <title>Assign Applicant</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="${contextPath}/resources/assets/css/main.css" />
    <link rel="stylesheet" href="${contextPath}/resources/assets/css/customize.css" />
    <script src="${contextPath}/resources/assets/js/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.17.0/dist/jquery.validate.js"></script>
    <script src="${contextPath}/resources/validator/validateAssign.js"></script>

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
            <form:form id="contact" method="POST" modelAttribute="assignForm" class="form-signin">
                <h2 class="form-signin-heading">Assign Applicant</h2>
                <span>${message}</span>
                <div class="row">
                <spring:bind path = "application_id">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="application_id" class="form-control" placeholder="application id"
                                    autofocus="true"></form:input>
                        <form:errors path="application_id"></form:errors>
                    </div>
                </spring:bind>

                <spring:bind path="nic">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="nic" class="form-control" placeholder="Parent Nic"
                                    autofocus="true"></form:input>
                        <form:errors path="nic"></form:errors>
                    </div>
                </spring:bind>
                </div>
            </br>
            <div class="row">
                <spring:bind path="sch_id1">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="sch_id1" class="form-control" placeholder="School id 1"
                                    autofocus="true" id="sch_id1" ></form:input>
                        <form:errors path="sch_id1"></form:errors>
                    </div>
                </spring:bind>

                <spring:bind path="distance1">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="distance1" class="form-control" placeholder="distance"
                                    autofocus="true"></form:input>
                        <form:errors path="distance1"></form:errors>
                    </div>
                </spring:bind>
            </div>

            <div class="row">
                <spring:bind path="sch_id2">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="sch_id2" class="form-control" placeholder="School id 2"
                                    autofocus="true" id="sch_id2" ></form:input>
                        <form:errors path="sch_id2"></form:errors>
                    </div>
                </spring:bind>

                <spring:bind path="distance2">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="distance2" class="form-control" placeholder="distance"
                                    autofocus="true"></form:input>
                        <form:errors path="distance2"></form:errors>
                    </div>
                </spring:bind>
            </div>

            <div class="row">
                <spring:bind path="sch_id3">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="sch_id3" class="form-control" placeholder="School id 3"
                                    autofocus="true" id="sch_id3" ></form:input>
                        <form:errors path="sch_id3"></form:errors>
                    </div>
                </spring:bind>

                <spring:bind path="distance3">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="distance3" class="form-control" placeholder="distance"
                                    autofocus="true"></form:input>
                        <form:errors path="distance3"></form:errors>
                    </div>
                </spring:bind>
            </div>

            <div class="row">
                <spring:bind path="sch_id4">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="sch_id4" class="form-control" placeholder="School id 4"
                                    autofocus="true" id="sch_id4" ></form:input>
                        <form:errors path="sch_id4"></form:errors>
                    </div>
                </spring:bind>

                <spring:bind path="distance4">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="distance4" class="form-control" placeholder="distance"
                                    autofocus="true"></form:input>
                        <form:errors path="distance4"></form:errors>
                    </div>
                </spring:bind>
            </div>

            <div class="row">
                <spring:bind path="sch_id5">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="sch_id5" class="form-control" placeholder="School id 5"
                                    autofocus="true" id="sch_id5"></form:input>
                        <form:errors path="sch_id5"></form:errors>
                    </div>
                </spring:bind>

                <spring:bind path="distance5">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="distance5" class="form-control" placeholder="distance"
                                    autofocus="true"></form:input>
                        <form:errors path="distance5"></form:errors>
                    </div>
                </spring:bind>
            </div>
        </br>

                <button class="button special" type="submit">Submit</button>
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



