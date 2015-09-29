<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="cmsStyle.css">
<script src="cmsJScript.js"></script>
<title>Add Course | Course Management System</title>
</head>
<body>
	<header>
		<jsp:include page="logo.jsp"></jsp:include>
		<h1>Course Management System</h1>
	</header>

	<div id="wrapper">
		<div id="main">
			<div id="heading">Add Course</div>
			<section>
				<div id="errorMessage">
					<c:if test="${requestScope.message!=null}">				
						<c:out value="${requestScope.message}"></c:out>				
					</c:if>		
				</div>		

				<form action="./AddCourseController" method="post"
					onSubmit="return checkIfEmpty()">
					<table>
						<tr>
							<td>Course Code</td>
							<td><input type="text" name="courseCode" id="courseCode"></td>
							<td><div class="formError">
									<div id="courseCodeError"></div>
								</div></td>
						</tr>
						<tr>
							<td>Course Name</td>
							<td><input type="text" name="courseName" id="courseName"></td>
							<td><div class="formError">
									<div id="courseNameError"></div>
								</div></td>
						</tr>
						<tr>
							<td>Course Description</td>
							<td><textarea rows="1" name="courseDescription"
									id="courseDescription" cols="60"></textarea></td>
							<td><div class="formError">
									<div id="courseDescriptionError"></div>
								</div></td>
						</tr>
						<tr>
							<td>Number of Participants</td>
							<td><input type="text" name="noOfParticipants"
								id="noOfParticipants"></td>
							<td><div class="formError">
									<div id="noOfParticipantsError"></div>
								</div></td>
						</tr>
						<tr>
							<td>Course Duration</td>
							<td><select name="courseDuration" id="courseDuration">
									<option value='' selected disabled></option>
									<option value="D1">D1</option>
									<option value="D2">D2</option>
									<option value="D3">D3</option>
							</select></td>
							<td><div class="formError">
									<div id="courseDurationError"></div>
								</div></td>
						</tr>
						<tr>
							<td>Course Type</td>
							<td><input type="radio" name="courseType" id="courseType"
								value="ClassRoom" checked="checked"> ClassRoom <input
								type="radio" name="courseType" id="courseType" value="ELearning">
								ELearning</td>
							<td><div class="formError">
									<div id="courseTypeError"></div>
								</div></td>
						</tr>
						<tr>
							<td><input type="submit" name="submit" value="Add Course"></td>
							<td><input type="reset" name="Reset" value="Reset"></td>
						</tr>
					</table>
				</form>
			</section>
		</div>
		<div id="footer"><jsp:include page="./footer.html"></jsp:include></div>
	</div>
</body>
</html>