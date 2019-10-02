<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./resources/CSS/main.css" >
<!-- <link rel="stylesheet" href=".\WebContent\WEB-INF\css\main.css" type="text/css"></link> -->
</head>
<body  class="loginPage">
		
		<div align="center">
			<h1>Hello User Please Login</h1>
			<table border="2">
			<form:form action="checkLogin.vin" modelAttribute="customer">
				<tr>
					<td>Username: </td>
					<td><form:input path="username"/></td>
				</tr>
				<tr>
					<td>Password: </td>
					<td><form:password path="password"/></td>
				</tr>
				<tr>
				<td>
					<input type="submit" value="Submit"></input>
				</td>
				</tr>
			</form:form>
			
			</table>
		</div>
	
</body>
</html>