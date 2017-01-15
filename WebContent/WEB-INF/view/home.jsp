<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" %>

<head>
<c:url value="/spitter/register" var="registerUrl"  scope="request"/>


</head>

<body>

<h1><s:message code="user.welcome"/></h1>




<a href="<c:url value="/spittles" />">Spittles</a> | 
<a href="${registerUrl}">Rejestracja</a>
</body>