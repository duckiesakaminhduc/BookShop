<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="email" method='post'>
		<label for="fname">To:</label><br> <input type="text" id="fname"
			name="to" value='21130447@st.hcmuaf.edu.vn'><br> <label
			for="lname">Subject:</label><br> <input type="text" id="lname"
			name="subject"><br> <label for="g">Content:</label><br>
		<input type="text" id="g" name="content"><br> <br> <input
			type="submit" value="Submit">
	</form>
</body>
</html>