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

    <link href="${contextPath}/resources/css/css1.css" rel="stylesheet">

    <script type="text/javascript">
 //<![CDATA[ 
 // array of possible countries in the same order as they appear in the country selection list 
 var countryLists = new Array(4) 
 countryLists["empty"] = ["Select a district"]; 
 countryLists["Gampaha"] = ["gampaha", "minuwangoda", "kaduwela","kelaniya"]; 
 countryLists["Colombo"] = ["colombo", "galkissa", "wellawaththa", "dehiwala"]; 
 countryLists["Kaluthara"] = ["kaluthara", "panadura", "wadduwa"]; 

 /* CountryChange() is called from the onchange event of a select element. 
 * param selectObj - the select object which fired the on change event. 
 */ 
 function countryChange(selectObj) { 
 // get the index of the selected option 
 var idx = selectObj.selectedIndex; 
 // get the value of the selected option 
 var which = selectObj.options[idx].value; 
 // use the selected option value to retrieve the list of items from the countryLists array 
 cList = countryLists[which]; 
 // get the country select element via its known id 
 var cSelect = document.getElementById("country"); 
 // remove the current options from the country select 
 var len=cSelect.options.length; 
 while (cSelect.options.length > 0) { 
 cSelect.remove(0); 
 } 
 var newOption; 
 // create new options 
 for (var i=0; i<cList.length; i++) { 
 newOption = document.createElement("option"); 
 newOption.value = cList[i];  // assumes option string and value are the same 
 newOption.text=cList[i]; 
 // add the new option 
 try { 
 cSelect.add(newOption);  // this will fail in DOM browsers but is needed for IE 
 } 
 catch (e) { 
 cSelect.appendChild(newOption); 
 } 
 } 
 } 
//]]>
</script>
<link href="${contextPath}/resources/css/css2.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<link rel="stylesheet" href="${contextPath}/resources/css/datepick.css">
  <script src="${contextPath}/resources/js/datepick1.js"></script>
  <script src="${contextPath}/resources/js/datepick2.js"></script>
    <script>
  $( function() {
    $( ".datepicker-1" ).datepicker({ dateFormat: 'yy-mm-dd',changeYear: true,changeMonth: true });
  } );
  </script>

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

                       <spring:bind path="gender">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <form:select type="text" path="gender" class="form-control" 
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
                <form:select type="text" path="religion" class="form-control" 
                            autofocus="true">
                                <form:option value="NO">Chose Religion</form:option>
                                <form:option value="buddhist">Buddhist</form:option>
                                <form:option value="Cristian">Christian</form:option>
                                <form:option value="hindu">Hinduism</form:option>
                                
                            </form:select>
                <form:errors path="religion"></form:errors>
            </div>
</spring:bind>

                               <spring:bind path="district">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:select type="text" path="district" class="form-control" id="continent" onchange="countryChange(this);"
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
                <form:select type="text" path="div_sec" class="form-control" id="country"
                            autofocus="true">
                    <form:option value="0">Select a district</form:option>
                </form:select>
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
        
      


        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>

</div>
<!-- /container -->

<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>

