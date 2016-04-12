<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String error=request.getParameter("error");
if(error==null || error=="null"){
 error="";
}
%>
<html>
<head>
<meta charset="utf-8">
<title>Bingo Login</title>

<style type="text/css">
body {
background-color: #f4f4f4;
color: #5a5656;
font-family: 'Open Sans', Arial, Helvetica, sans-serif;
font-size: 16px;
line-height: 1.5em;
}
a { text-decoration: none; }
h1 { font-size: 1em; }
h1, p {
margin-bottom: 10px;
}
strong {
font-weight: bold;
}
.uppercase { text-transform: uppercase; }

/* ---------- LOGIN ---------- */
#login {
margin: 50px auto;
width: 300px;
}
form fieldset input[type="text"], input[type="password"] {
background-color: #e5e5e5;
border: none;
border-radius: 3px;
-moz-border-radius: 3px;
-webkit-border-radius: 3px;
color: #5a5656;
font-family: 'Open Sans', Arial, Helvetica, sans-serif;
font-size: 14px;
height: 50px;
outline: none;
padding: 0px 10px;
width: 280px;
-webkit-appearance:none;
}
form fieldset input[type="submit"] {
background-color: #008dde;
border: none;
border-radius: 3px;
-moz-border-radius: 3px;
-webkit-border-radius: 3px;
color: #f4f4f4;
cursor: pointer;
font-family: 'Open Sans', Arial, Helvetica, sans-serif;
height: 50px;
text-transform: uppercase;
width: 300px;
-webkit-appearance:none;
}
form fieldset a {
color: #5a5656;
font-size: 10px;
}
form fieldset a:hover { text-decoration: underline; }
.btn-round {
background-color: #5a5656;
border-radius: 50%;
-moz-border-radius: 50%;
-webkit-border-radius: 50%;
color: #f4f4f4;
display: block;
font-size: 12px;
height: 50px;
line-height: 50px;
margin: 30px 125px;
text-align: center;
text-transform: uppercase;
width: 50px;
}
.error {
    color: #ff0000;
    font-style: italic;
    font-weight: bold;
    font-size:10px;
}
</style>
</head>
<body>
<div id="login">
<div class="error">${error}</div>
<h1><strong>Welcome.</strong> Please login.</h1>
<form:form id="loginForm" method="POST" action="checklogin.do" commandName="userForm" modelAttribute="userLogin">
	<fieldset>
	<!-- <p><input type="text" required placeholder="Username" onBlur="if(this.value=='')this.value='Username'" onFocus="if(this.value=='Username')this.value='' "></p>
	<p><input type="password" required placeholder="Password" onBlur="if(this.value=='')this.value='Password'" onFocus="if(this.value=='Password')this.value='' "></p> -->
		<p><form:input id="username" name="username" path="username" placeholder="Username"/><p>
		<form:errors path="username" cssClass="error"/>
		
		<p><form:password id="password" name="password" path="password" placeholder="Password"/><p>
		<form:errors path="password" cssClass="error"/>
		
		<p><a href="#">Forgot Password?</a></p>
		<p><input type="submit" value="Login"></p>
		Don't have a account? <a href="registration.do">Click here<a></a> to create one</a>
	</fieldset>
</form:form>
</div>
</body>
</html>

<%-- <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring mvc</title>
</head>
<body>
	<form:form id="loginForm" method="POST" action="checklogin.do" modelAttribute="userLogin">
            <form:label path="username">Enter your user-name</form:label>
            <form:input id="username" name="username" path="username" /><br>
            <form:label path="username">Please enter your password</form:label>
            <form:password id="password" name="password" path="password" /><br>
            <input type="submit" value="Submit" />
    </form:form>
	
</body>
</html> --%>