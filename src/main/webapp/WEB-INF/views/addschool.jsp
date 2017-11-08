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

    <title>Add School</title>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/css1.css" rel="stylesheet">

    <script type="text/javascript">
 //<![CDATA[ 
 // array of possible countries in the same order as they appear in the country selection list 
 var countryLists = new Array(10) 
 countryLists["empty"] = ["Select a district"]; 
 countryLists["Northern"] = ["Jaffna", "Kilinochchi", "Mannar","Mullaitivu","Vavuniya"]; 
 countryLists["NorthWestern"] = ["Puttalam", "Kurunegala"]; 
 countryLists["Western"] = ["Gampaha", "Colombo", "Kaluthara"]; 
 countryLists["NorthCentral"] = ["Anuradhapura", "Polonnaruwa"]; 
 countryLists["Central"] = ["Matale", "Kandy", "NuwaraEliya"]; 
 countryLists["Sabaragamuwa"] = ["Kegalle", "Ratnapura"]; 
 countryLists["Eastern"] = ["Trincomalee", "Batticaloa", "Ampara"]; 
 countryLists["Uva"] = ["Badulla", "Monaragala"]; 
 countryLists["Southern"] = ["Hambantota", "Matara", "Galle"]; 

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
                <form:select type="text" path="province" class="form-control" id="continent" onchange="countryChange(this);"
                            autofocus="true">
                    <form:option value="empty">Select a District</form:option>
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
                <form:select type="text" path="district" class="form-control" id="country"
                            autofocus="true">
                    <form:option value="0">Select a district</form:option>
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
           
           <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>
</div>
<!-- /container -->

<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
         
