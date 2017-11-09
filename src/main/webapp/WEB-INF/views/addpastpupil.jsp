<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Add applicant</title>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/css2.css" rel="stylesheet">

    <link rel="stylesheet" href="${contextPath}/resources/css/datepick.css">
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
        
        
        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>
</div>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>