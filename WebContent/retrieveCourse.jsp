<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="cmsStyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Retrieve Course | Course Management System</title>
</head>
<body>
	<header>
		<jsp:include page="logo.jsp"></jsp:include>
		<h1>Course Management System</h1>
	</header>
	<div id="wrapper">
		<div id="main">
			<div id="heading">Retrieve Course</div>

			<section>
				<c:if test="${requestScope.message!=null}">
					<div id="errorMessage">
						<c:out value="${requestScope.message}"></c:out>
					</div>
				</c:if>

				<div id="retrieveCourseSection">
					<form method="post" action="./RetrieveCourseController">
						<table>
							<tr>
								<td>Course Code</td>
								<td><input type="text" name="courseCode"></td>
							</tr>
							<tr>
								<td><input type="submit" name="retrieve"
									value="Retrieve Course"></td>
								<td><input type="reset" name="reset" value="Reset"></td>
							</tr>
						</table>
					</form>
				</div>
			</section>
		</div>

		<div id="footer">
			<jsp:include page="./footer.html"></jsp:include>
		</div>
	</div>
</body>
</html>