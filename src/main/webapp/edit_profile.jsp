<%@page import="model.User"%>
<%@page import="java.util.List"%>
<%@page import="connectDB.DBConnect"%>
<%@page import="dao.UserDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="all_component/style.css">

<title>Insert title here</title><%@include
	file="all_component/allCss.jsp"%>

</head>
<body>
	<%
	String username = (String) session.getAttribute("username");
	UserDAOImpl userDAOImpl = new UserDAOImpl(new DBConnect().getConn());
	List<User> userList = userDAOImpl.getUserByUserName(username);
	User u = userList.get(0);	
	
	%>
	<%@include file="all_component/navbar.jsp"%>
	<section id="register">
		<h1 class="text-center text-light">Edit Profile</h1>
		<div class="container bg-light">

			<form action='edit_profile' method='post'>
				<div class="form-group">
					<label for="username">Username</label> <input type="text"
						class="form-control" id="username"
						value="<%=u.getUserName()%>">
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">Email address</label> <input
						type="email" class="form-control" id="exampleInputEmail1"
						aria-describedby="emailHelp" name='email' value="<%=u.getEmail()%>"> <small
						id="emailHelp" class="form-text text-muted">We'll never
						share your email with anyone else.</small>
				</div>

				<div class="form-group">
					<label for="exampleInputPassword1">Password</label> <input
						type="password" class="form-control" id="exampleInputPassword1"
						name='password' value="<%=u.getPassword()%>">
				</div>
				<div class="form-group">
					<label for="phone">Phone</label> <input type="text"
						class="form-control" id="phone" name='phone' value="<%=u.getPhone()%>">
				</div>

				<div class="form-group form-check">
					<input type="checkbox" class="form-check-input" id="exampleCheck1">
					<label class="form-check-label" for="exampleCheck1">Check
						me out</label>
				</div>
				<div class="text-center">
					<button type='submit' class="bg-primary mb-2 text-light">Apply</button>
				</div>
			</form>


		</div>

	</section>
</body>
</html>