<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE HTML>
<html>
<head>
    <title>Add School</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="${contextPath}/resources/assets/css/main.css" />
    <link rel="stylesheet" href="${contextPath}/resources/assets/css/customize.css" />
    <script src="${contextPath}/resources/assets/js/jquery.min.js"></script>
    <script src="${contextPath}/resources/assets/js/customize2.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.17.0/dist/jquery.validate.js"></script>
    <script src="${contextPath}/resources/validator/validateSchool.js"></script>
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
            <form:form id="contact" method="POST" modelAttribute="schoolForm" class="form-signin">
                <h2 class="form-signin-heading">Add school details</h2>

                <span>${message}</span>

                <spring:bind path = "sch_id">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="sch_id" class="form-control" placeholder="school id"
                                    autofocus="true"></form:input>
                        <form:errors path="sch_id"></form:errors>
                    </div>
                </spring:bind>

                <spring:bind path="name">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="name" class="form-control" placeholder="name"
                                    autofocus="true"></form:input>
                        <form:errors path="name"></form:errors>
                    </div>
                </spring:bind>

                <spring:bind path="province">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:select type="text" path="province" class="select_mate" id="continent" onchange="countryChange(this);"
                                     autofocus="true">
                            <form:option value="empty">Select a Province</form:option>
                            <form:option value="Northern">Northern</form:option>
                            <form:option value="NorthWestern">NorthWestern</form:option>
                            <form:option value="Western">Western</form:option>
                            <form:option value="NorthCentral">NorthCentral</form:option>
                            <form:option value="Central">Central</form:option>
                            <form:option value="Sabaragamuwa">Sabaragamuwa</form:option>
                            <form:option value="Eastern">Eastern</form:option>
                            <form:option value="Uva">Uva</form:option>
                            <form:option value="Southern">Southern</form:option>
                        </form:select>
                        <form:errors path="province"></form:errors>
                    </div>
                </spring:bind>

                <spring:bind path="district">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:select type="text" path="district" class="select_mate" id="country"
                                     autofocus="true">
                            <form:option value="0">Select a District</form:option>
                        </form:select>
                        <form:errors path="district"></form:errors>
                    </div>
                </spring:bind>

                <spring:bind path="division">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="division" class="form-control" placeholder="division"
                                    autofocus="true"></form:input>
                        <form:errors path="division"></form:errors>
                    </div>
                </spring:bind>

                <spring:bind path="eligible_count">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="eligible_count" class="form-control" placeholder="eligible_count"
                                    autofocus="true"></form:input>
                        <form:errors path="eligible_count"></form:errors>
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
<script src="${contextPath}/resources/assets/js/jquery.dropotron.min.js"></script>
<script src="${contextPath}/resources/assets/js/jquery.scrolly.min.js"></script>
<script src="${contextPath}/resources/assets/js/jquery.scrollgress.min.js"></script>
<script src="${contextPath}/resources/assets/js/skel.min.js"></script>
<script src="${contextPath}/resources/assets/js/util.js"></script>
<script src="${contextPath}/resources/assets/js/main.js"></script>

</body>
</html>



