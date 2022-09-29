<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="jakarta.servlet.http.HttpSession"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Students of a Class</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body style="background-image: url('css/background.jpg');">
<div id="page" >
	<jsp:include page="left-list.jsp" />

	
		<div id="wrapper">

			<div id="header">
				<h3>Students of ${SUBJECT} class cname ${CNAME} </h3>
			</div>
		</div>


		<div id="container">

			<div id="content">

				<table>

					<tr>

						<th>First Name</th>
						<th>Last Name</th>
						<th>age</th>

					</tr>

					<c:forEach var="tempStudent" items="${STUDENTS_LIST}">
						<tr>

							<td>${tempStudent.fname}</td>
							<td>${tempStudent.lname}</td>
							<td>${tempStudent.age}</td>



						</tr>


					</c:forEach>

				</table>
			</div>
		</div>
	</div>
<button  onclick="history.back()">Go Back</button>

</body>
</html>