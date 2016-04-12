<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bingo</title>
<script>
var id = "${id}"; 
</script>
</head>
<body>
<h1>Welcome Login Successfully</h1>
${message} 
<a href="editGetUser.do?id=${id}">Edit Profile</a>
</body>
</html>