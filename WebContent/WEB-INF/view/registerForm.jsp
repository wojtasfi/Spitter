<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
	

<title>Registration</title>

</head>
<body>
	<h1>Registration Form</h1>

	<f:form modelAttribute="user" method="POST">
	<f:errors path="*" element="div" cssClass="errors" />
<!--  cssClass robi to jak span więc musi być span.errors 
<f:errors path="lastName" cssClass="error" />-->

<f:label path="firstName" cssErrorClass="error">First name: </f:label>
<f:input path="firstName" cssErrorClass="error" />

		<br>
<f:label path="lastName" cssErrorClass="error">Last name: </f:label>
<f:input path="lastName" cssErrorClass="error" />

		<br>
<f:label path="email" cssErrorClass="error">Email: </f:label>
<f:input path="email" type="email" cssErrorClass="error"/>

		<br>
<f:label path="login" cssErrorClass="error">Login: </f:label>
<f:input path="login" cssErrorClass="error" />

		<br>
<f:label path="password" cssErrorClass="error">Password: </f:label>
<f:password path="password" cssErrorClass="error" />

		<br>

		<input type="submit" value="Register" />
	</f:form>

</body>
</html>