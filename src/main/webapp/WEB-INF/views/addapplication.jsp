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

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/css1.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>



    <form:form method="POST" modelAttribute="applicantForm" class="form-signin">
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
                <form:input type="text" path="dob" class="form-control" placeholder="date of birth"
                            autofocus="true"></form:input>
                <form:errors path="dob"></form:errors>
            </div>
</spring:bind>
                       <spring:bind path="gender">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="gender" class="form-control" placeholder="gender"
                            autofocus="true"></form:input>
                <form:errors path="gender"></form:errors>
            </div>
</spring:bind>
                <spring:bind path="religion">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="religion" class="form-control" placeholder="religion"
                            autofocus="true"></form:input>
                <form:errors path="religion"></form:errors>
            </div>
</spring:bind>

                <spring:bind path="age">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="age" class="form-control" placeholder="age"
                            autofocus="true"></form:input>
                <form:errors path="age"></form:errors>
            </div>
</spring:bind>
                               <spring:bind path="district">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="district" class="form-control" placeholder="district"
                            autofocus="true"></form:input>
                <form:errors path="district"></form:errors>
            </div>
</spring:bind>
                       <spring:bind path="div_sec">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="div_sec" class="form-control" placeholder="secretary division"
                            autofocus="true"></form:input>
                <form:errors path="div_sec"></form:errors>
            </div>
</spring:bind>
                <spring:bind path="div_grama">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="div_grama" class="form-control" placeholder="grama division"
                            autofocus="true"></form:input>
                <form:errors path="div_grama"></form:errors>
            </div>
</spring:bind>
      


        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>


<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>

