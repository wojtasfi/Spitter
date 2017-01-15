<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<a href="${pageContext.request.contextPath}/homepage">Home Page</a>
	<div class="addSpittle">

		<h1>Add spittle</h1>
		<form method=POST name="spittleForm">
			<textarea name="message" cols="50" rows="5"></textarea>
			<br>
			<br> <input type="submit" value="Add" />


		</form>

	</div>

	<h1>Last spittles</h1>
	<ul style="list-style-type: circle">
		<c:forEach items="${spittleList}" var="spittle">
			<input type="hidden" name="id" value="${spittle.spittleId}" />
			
			<li id="spittle_<c:out value="${spittle.spittleId}"/>">
				<div class="spittleMessage">

					<c:out value="${spittle.message}" />
				</div>

				<div>
					<span class="spittleTime"><c:out value="${spittle.time}" /></span>
					<span class="spittleLocation"> (<c:out
							value="${spittle.latitude}" /> <c:out
							value="${spittle.longitude}" />)
					</span>
				</div>
				<div class="spittleButton">
					<!--  <input type="button" onclick="/spittles/${spittle.spittleId}" value="Check out" /> -->
					<input type="button" onclick="location.href='/Spitter/spittles/${spittle.spittleId}'" value="Check out" />
				</div>
		</c:forEach>
	</ul>
</body>
</html>