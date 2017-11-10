<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<!DOCTYPE HTML>
<html>
<head>
    <title>Login To the System</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="${contextPath}/resources/assets/css/main.css" />
    <link rel="stylesheet" href="${contextPath}/resources/assets/css/customize.css" />
    <script src="${contextPath}/resources/assets/js/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.17.0/dist/jquery.validate.js"></script>
    <script src="${contextPath}/resources/validator/validateLogin.js"></script>
</head>
<body class="index">
<div id="page-wrapper">

    <!-- Header -->
    <header id="header" class="alt">
        <h1 id="logo"><a href="login">Grade One Evaluating System</a></h1>
    </header>

    <section id="banner">
        <div class="inner">

            <header>
                <p>Login to The System</p>
            </header>

            <form id = "form-sign-in" method="POST" action="${contextPath}/login" class="form-signin">
                <div class="form-group ${error != null ? 'has-error' : ''}">

                    <span><p class="alert-info"> ${message}</p></span>
                    <br>

                    <input name="username" type="text" class="form-control" placeholder="Username"
                           autofocus="true"/>
                    <br>
                    <input name="password" type="password" class="form-control" placeholder="Password"/>
                    <br>
                    <span><p class="alert-danger">${error}</p> </span>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <br>
                    <button class="button special" type="submit">Log In</button>

                </div>

            </form>

        </div>
    </section>

    <footer id="footer">
        <ul class="copyright">
            <li><strong>Grade One Evaluating System - Ministry Of Education</strong></li>
        </ul>
        <img width="130px" height="auto" src="${contextPath}/resources/images/Aurora-logo.png" alt="">
    </footer>
    
    <script src="${contextPath}/resources/assets/js/jquery.dropotron.min.js"></script>
    <script src="assets/js/jquery.scrolly.min.js"></script>
    <script src="${contextPath}/resources/assets/js/jquery.scrollgress.min.js"></script>
    <script src="${contextPath}/resources/assets/js/skel.min.js"></script>
    <script src="${contextPath}/resources/assets/js/util.js"></script>
    <script src="${contextPath}/resources/assets/js/main.js"></script>

</body>
</html>
