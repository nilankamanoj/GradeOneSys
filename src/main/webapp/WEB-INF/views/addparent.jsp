<%-- 
    Document   : addparent
    Created on : Nov 8, 2017, 11:36:34 AM
    Author     : Sithara wanigasooriy
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <!--<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">-->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        
        <title>Add Parent</title>
        
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
        <link href="${contextPath}/resources/css/css2.css" rel="stylesheet">

        
        
    </head>
    <body>

        ${nav}
        <ul class="nav navbar-nav navbar-right">

            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                        <span class="glyphicon glyphicon-user"></span>&nbsp;Hi' ${pageContext.request.userPrincipal.name}&nbsp;<span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                <li><a href="profile"><span class="glyphicon glyphicon-user"></span>&nbsp;View Profile</a></li>
                                <li><a href="changepass"><span class="glyphicon glyphicon-user"></span>&nbsp;Change Password</a></li>
                                <li><a onclick="document.forms['logoutForm'].submit()"><span class="glyphicon glyphicon-log-out"></span>&nbsp;Sign Out</a></li>

                                </ul>
        </li>
        </ul>
        </div>
        <div class="container">
        <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        </c:if>
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
                <form:select type="text" path="gender" class="form-control" 
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
        
        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>
        </div>
<!<-- /container -->

        <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
    </body>
</html>
