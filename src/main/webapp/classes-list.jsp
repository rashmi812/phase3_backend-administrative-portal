
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Classes</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body style="background-image: url('css/background.jpg');">
	<div id="page">
		<jsp:include page="left-list.jsp" />


		<div id="wrapper">

			<div id="header">
				<h3>Classes</h3>
			</div>
		</div>


		<div id="container">

			<div id="content">

				<table>

					<tr>

						<th>Cname</th>
						<th>Subject</th>
						<th>Teacher</th>
						<th>List of Students</th>

					</tr>

					<c:forEach var="tempClass" items="${CLASSES_LIST }">
						<tr>

							<c:url var="tempLink" value="ControllerServlet">
								<c:param name="command" value="ST_LIST" />
								<c:param name="classId" value="${tempClass.id }" />
								<c:param name="cname" value="${tempClass.cname }" />
								<c:param name="subject" value="${tempClass.subject }" />
							</c:url>

							<td>${tempClass.cname}</td>
							<td>${tempClass.subject}</td>
							<td>${tempClass.teacher}</td>
						
							<td><a href="${tempLink }">List</a></td>
 




						</tr>


					</c:forEach>

				</table>
			</div>
		</div>
	</div>

</body>
</html>