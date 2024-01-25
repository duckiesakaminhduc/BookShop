<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="all_component/style.css">
<title>Insert title here</title>
<%@include file="all_component/allCss.jsp"%>

</head>
<body>
	<section id="login">
		<h1 class="text-center text-light">Login</h1>
		<div class="container bg-light">
		
		<c:if test="${not empty yess }">
			<h2 class='text-center text-success'>${yess}</h2>
			<c:remove var="yess" scope='session' />
		</c:if>
		
		<c:if test="${not empty login_fail }">
			<h2 class='text-center text-danger'>${login_fail}</h2>
			<c:remove var="login_fail" scope='session' />
		</c:if>
		
			<form action='login' method='post'>
				<div class="form-group">
					<label for="username">Username</label> <input type="text"
						class="form-control" id="username" name='username'>
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Password</label> <input
						type="password" class="form-control" id="exampleInputPassword1" name='password'>
				</div>
				<div class="text-center">
					<div>
					<button type='submit' class="bg-primary mb-2 text-light">Login</button>
					</div>
					<div id="createAcc">
						<a href="register.jsp">Create new account</a>
					</div>
				</div>
			</form>
			
			
		</div>

	</section>
</body>
</html>