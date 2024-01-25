<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="all_component/style.css">
<title>Document</title>
<%@include file="all_component/allCss.jsp"%></head>
<body>
	<style>
.card-body i {
	font-size: 10em;
}
</style>

	<%@include file="all_component/navbar.jsp"%>

	<h1 class="text-center">Hello Admin</h1>

	<c:if test="${not empty edit_v }">
		<h5 class='text-center text-success'>${edit_v }</h5>
		<c:remove var="edit_v" scope="session" />
	</c:if>

	<section id="bar-admin">
		<div class="container">

			<div class="row">
				<div class="col-md-4">
					<a href="edit_profile.jsp">
						<div class="card text-center" style="width: auto;">
							<div class="card-body">
								<p class="card-text">
									<i class="fa-solid fa-pen-to-square" style="color: #66ff00;"></i>
								</p>
								<h2 class="card-title font-weight-bold">
									<a href="">Edit profile</a>
								</h2>
							</div>
						</div>
					</a>
				</div>
				<div class="col-md-4">
					<a href="order.jsp">
						<div class="card text-center" style="width: auto;">
							<div class="card-body">
								<p class="card-text">
									<i class="fa-solid fa-store" style="color: #ffea00;"></i>
								</p>
								<h2 class="card-title font-weight-bold">
									<a href="">My Order</a>
								</h2>
							</div>
						</div>
					</a>
				</div>
				<div class="col-md-4">
					<a href="contact.jsp">
						<div class="card text-center" style="width: auto;">
							<div class="card-body">
								<p class="card-text">
									<i class="fa-solid fa-circle-info" style="color: #ff5900;"></i>
								</p>
								<h2 class="card-title font-weight-bold">
									<a href="">Help Center</a>
								</h2>
							</div>
						</div>
					</a>
				</div>
			</div>
		</div>
	</section>
</body>
</html>