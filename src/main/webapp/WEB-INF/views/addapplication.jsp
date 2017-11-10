<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE HTML>
<html>
<head>
    <title>Add Application</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="${contextPath}/resources/assets/css/main.css" />
    <link rel="stylesheet" href="${contextPath}/resources/assets/css/customize.css" />
    <link rel="stylesheet" href="${contextPath}/resources/css/datepick.css">
    <script src="${contextPath}/resources/js/datepick1.js"></script>
    <script src="${contextPath}/resources/js/datepick2.js"></script>
    <script src="${contextPath}/resources/assets/js/customize.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.17.0/dist/jquery.validate.js"></script>
    <script src="${contextPath}/resources/validator/validateApp.js"></script>
    <script>
        $( function() {
            $( ".datepicker-1" ).datepicker({ dateFormat: 'yy-mm-dd',changeYear: true,changeMonth: true });
        } );
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
        <form:form id="contact" method="POST" modelAttribute="applicantForm" class="form-signin">
            <h2 class="form-signin-heading">Add application details</h2>
            <span>${message}</span>

            <spring:bind path = "Id">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="Id" class="form-control" placeholder="application id"
                                autofocus="true"></form:input>
                    <form:errors path="Id"></form:errors>
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

            <spring:bind path="dob">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="dob" class="datepicker-1" placeholder = "date of birth"></form:input>
                    <form:errors path="dob"></form:errors>
                </div>
            </spring:bind>
<div class="row">
            <spring:bind path="gender">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:select type="text" path="gender" class="select_mate"
                                 autofocus="true">
                        <form:option value="NO">Chose Gender</form:option>
                        <form:option value="male">Male</form:option>
                        <form:option value="fmale">Female</form:option>
                    </form:select>
                    <form:errors path="gender"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="religion">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:select type="text" path="religion" class="select_mate"
                                 autofocus="true">
                        <form:option value="NO">Chose Religion</form:option>
                        <form:option value="buddhist">Buddhist</form:option>
                        <form:option value="Cristian">Christian</form:option>
                        <form:option value="hindu">Hinduism</form:option>
                    </form:select>
                    <form:errors path="religion"></form:errors>
                </div>
            </spring:bind>
</div>
<div class="row">
            <spring:bind path="district">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:select type="text" path="district" class="select_mate" id="continent" onchange="countryChange(this);"
                                 autofocus="true">
                        <form:option value="empty">Select a District</form:option>
                        <form:option value="Gampaha">Gampaha</form:option>
                        <form:option value="Colombo">Colombo</form:option>
                        <form:option value="Kaluthara">Kaluthara</form:option>
                    </form:select>
                    <form:errors path="district"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="div_sec">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:select type="text" path="div_sec" class="select_mate" id="country"
                                 autofocus="true">
                        <form:option value="0">Select a district</form:option>
                    </form:select>
                    <form:errors path="div_sec"></form:errors>
                </div>
            </spring:bind>
</div>

            <spring:bind path="div_grama">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="div_grama" class="form-control" placeholder="grama division"
                                autofocus="true"></form:input>
                    <form:errors path="div_grama"></form:errors>
                </div>
            </spring:bind>
<div class="row">
            <spring:bind path="electro_cert">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:checkbox path="electro_cert" value="true" label="electrical certified"></form:checkbox>
                    <form:errors path="electro_cert"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="grama_cert">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:checkbox path="grama_cert" value="true" label="grama certified"></form:checkbox>
                    <form:errors path="grama_cert"></form:errors>
                </div>
            </spring:bind>
</div>
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



