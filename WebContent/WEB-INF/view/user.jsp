<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
	
<title>Profile</title>
</head>
<body>

<h1>Profile</h1>

<c:out value="${user.login}" /><br>
<c:out value="${user.firstName}" /><br>
<c:out value="${user.lastName}" /><br>
<c:out value="${user.email}" /><br>

</body>
</html>