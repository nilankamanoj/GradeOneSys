<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE HTML>
<html>
<head>
    <title>Add Parent</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="${contextPath}/resources/assets/css/main.css" />
    <link rel="stylesheet" href="${contextPath}/resources/assets/css/customize.css" />
    <script src="${contextPath}/resources/assets/js/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.17.0/dist/jquery.validate.js"></script>
    <script src="${contextPath}/resources/validator/validateParent.js"></script>
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
        <form:form id="contact" method="POST" modelAttribute="parentForm" class="form-signin">
            <h2 class="form-signin-heading">Add Parent details</h2>
            <span>${message}</span>

            <spring:bind path = "NIC">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="NIC" class="form-control" placeholder="NIC"
                                autofocus="true"></form:input>
                    <form:errors path="NIC"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="first_name">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="first_name" class="form-control" placeholder="first name"
                                autofocus="true"></form:input>
                    <form:errors path="first_name"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="second_name">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="second_name" class="form-control" placeholder="second_name"
                                autofocus="true"></form:input>
                    <form:errors path="second_name"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="initials">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="initials" class="form-control" placeholder="initials"
                                autofocus="true"></form:input>
                    <form:errors path="initials"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="occupation">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="occupation" class="form-control" placeholder="occupation"
                                autofocus="true"></form:input>
                    <form:errors path="occupation"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="gender">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:select type="text" path="gender" class="select_mate"
                                 autofocus="true">
                        <form:option value="NO">Choose Gender</form:option>
                        <form:option value="male">Male</form:option>
                        <form:option value="fmail">Female</form:option>
                    </form:select>
                    <form:errors path="gender"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="telephone_no">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="telephone_no" class="form-control" placeholder="telephone_no"
                                autofocus="true"></form:input>
                    <form:errors path="telephone_no"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="email">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="email" class="form-control" placeholder="email"
                                autofocus="true"></form:input>
                    <form:errors path="email"></form:errors>
                </div>
            </spring:bind>

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



