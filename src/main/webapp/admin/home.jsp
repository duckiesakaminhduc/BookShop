<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="../all_component/allCss.jsp"%>

</head>
<body>
	<style>
.card-body i {
	font-size: 10em;
}
</style>
	<%@include file="header.jsp"%>
	<h1 class="text-center">Hello Admin</h1>
	<section id="bar-admin">
		<div class="container">
			<div class="row">
				<div class="col-md-3">
					<a href="add_book.jsp">
						<div class="card text-center" style="width: auto;">
							<div class="card-body">
								<p class="card-text">
									<i class="fa-solid fa-square-plus" style="color: #116fd4;"></i>
								</p>
								<h2 class="card-title font-weight-bold">
									<a href="">ADD</a>
								</h2>
							</div>
						</div>
					</a>
				</div>
				<div class="col-md-3">
					<a href="all_book.jsp">
						<div class="card text-center" style="width: auto;">
							<div class="card-body">
								<p class="card-text">
									<i class="fa-solid fa-book-open" style="color: #f20d3b;"></i>
								</p>
								<h2 class="card-title font-weight-bold">
									<a href="">ALL BOOK</a>
								</h2>
							</div>
						</div>
					</a>
				</div>
				<div class="col-md-3">
					<a href="order_book.jsp">
						<div class="card text-center" style="width: auto;">
							<div class="card-body">
								<p class="card-text">
									<i class="fa-solid fa-store" style="color: #eeff00;"></i></i>
								</p>
								<h2 class="card-title font-weight-bold">
									<a href="">ORDER</a>
								</h2>
							</div>
						</div>
					</a>
				</div>
				<div class="col-md-3">
					<a onclick="myFunction()" href="">
						<div class="card text-center" style="width: auto;">
							<div class="card-body">
								<p class="card-text">
									<i class="fa-solid fa-right-from-bracket"
										style="color: #1366f6;"></i>
								</p>
								<h2 class="card-title font-weight-bold">
									<a href="../login.jsp">LOG OUT</a>
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