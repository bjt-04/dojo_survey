<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Survey</h2>
	<p>the date is : ${myDate}</p>
	<p>
		x is :
		<c:out value="${x}" />
	</p>
	<p>y is : ${y}</p>

	<form action="/process_form" method="POST">
		name: ${error} <input type="text" name="name" /><br /> language: <select
			name="language">
			<option value="java">JAVA</option>
			<option value="python">Python</option>
			<option value="c++">C++</option>
		</select> <br> comment:
		<textarea name="comment" cols="30" rows="5"></textarea>
		<br>
		<button>submit</button>
		<!-- <input type="submit" value="go!!"/> -->
	</form>
</body>
</html>