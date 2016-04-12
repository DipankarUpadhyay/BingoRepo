<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String pageType=request.getParameter("pageType");
if(pageType==null || pageType=="null"){
	pageType="";
}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.error {
    color: #ff0000;
    font-style: italic;
    font-weight: bold;
    font-size:12px;
}
</style>
<script type="text/javascript">
function formSubmitClick() {
	pageType="${pageType}";
	if(pageType=='new'){
	  //alert("=======signup========"+pageType);
	  document.getElementById('signUpForm').action = 'signup.do';
	  document.getElementById('signUpForm').method = 'POST';
	}
	else{
		//alert("======updateUser========="+pageType);
		document.getElementById('signUpForm').action = 'updateUser.do';
		document.getElementById('signUpForm').method = 'POST';
	}
	return true;
}
	
</script>
</head>
<body>
<form:form id="signUpForm" name="signUpForm" onsubmit="formSubmitClick();" modelAttribute="userSignUp">
		<fieldset align="center">
			<!-- <p>Username : <input type="username" name="username" path="username"/></p> onSubmit="return formSubmitClick();"-->
			<p>Username : <form:input id="username" name="username" path="userName"/><p>
			<form:errors path="userName" cssClass="error"/>
 
			<!-- <p>Password : <input type="password" name="password" path="password"/></p> -->
			<p>Password : <form:input id="password" name="password" path="password"/><p>
			<form:errors path="password" cssClass="error"/>
 
			<!-- <p>First name : <input type="surname" name="firstName" path="firstName"/></p> -->
			<p>First name : <form:input id="firstName" name="firstName" path="firstName"/><p>
			<form:errors path="firstName" cssClass="error"/>
 
			<!-- <p>Last Names : <input type="other names" name="lastNames" path="lastNames"/></p> -->
			<p>Last Names : <form:input id="lastName" name="lastName" path="lastName"/><p>
			
			<!-- <p>Age : <input type="text" name="age" path="age"/></p> -->
			<p>Age : <form:input id="age" name="age" path="age"/><p>
			<form:errors path="age" cssClass="error"/>
 
			<!-- <p>Email : <input type="email" name="email" path="email"/></p> -->
			<p>Email : <form:input id="email" name="email" path="email"/><p>
			<form:errors path="email" cssClass="error"/>
 	
 			<p>Sex :  <form:radiobutton name="sex" value="male" path="sex"/>Male</br>
 					  <form:radiobutton name="sex" value="female" path="sex"/>Female</p>
 					  <form:errors path="sex" cssClass="error"/>
			
			<!-- <p>Telephone: <input type="telephone" name="tel"/></p> -->
			<p>Telephone: <form:input id="telephone" name="telephone" path="telephone"/><p>
 
			<!-- <p>Address : <input type="address" name="address" path="address"/></p> -->
			<p>Address : <form:input id="address" name="address" path="address"/><p>

			<input type="submit" value="Submit" />
			<form:hidden path="id" />
		</fieldset>
	</form:form>
</body>
</html>