
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List</title>
</head>
<body>
	<div class="sidenav">
	<h3 id="logo">
		Administrative <br /> Academy Portal
	</h3>
	<c:url var="classesLink" value="ControllerServlet">
		<c:param name="command" value="CLASSES" />
	</c:url>

	<c:url var="subjectsLink" value="ControllerServlet">
		<c:param name="command" value="SUBJECTS" />
	</c:url>

	<c:url var="teachersLink" value="ControllerServlet">
		<c:param name="command" value="TEACHERS" />
	</c:url>

	<c:url var="studentsLink" value="ControllerServlet">
		<c:param name="command" value="STUDENTS" />
	</c:url>

	<a class="bar-item" href="${classesLink}">Classes</a> 
		<a class="bar-item" href="${subjectsLink}">Subjects</a>
		<a class="bar-item" href="${teachersLink}">Teachers</a> 
		<a class="bar-item" href="${studentsLink}">Students</a> 
		<a class="bar-item" href="login.jsp">Log out</a>

</div>

	
</body>
</html>