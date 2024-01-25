
<%@page import="dao.UserDAOImpl"%>
<%@page import="connectDB.DBConnect"%>
<%@page import="dao.BookDAOImpl"%>
<%@page import="model.BooksAdd"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="all_component/style.css">
<title>Document</title>
<%@include file="all_component/allCss.jsp"%>
</head>

<body>
	<%@include file="all_component/navbar.jsp"%>
	<!--  -->
	<%
	String username = (String) session.getAttribute("username");
	UserDAOImpl daoImpl = new UserDAOImpl(new DBConnect().getConn());
	%>

	<%
	String bookId = request.getParameter("bookId");
	int b = Integer.parseInt(request.getParameter("bookId"));
	BooksAdd booksAdd = new BookDAOImpl(new DBConnect().getConn()).getBookById(b);
	%>

	<section id="view-book">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<div class="card" style="width: 15em;">
						<img src="image/<%=booksAdd.getPhoto()%>" class="card-img-top"
							alt="...">
						<div class="card-body">
							<h5 class="card-title text-center"><%=booksAdd.getBookName()%></h5>
							<p class="card-text text-center">
								Price:
								<%=booksAdd.getPrice()%>
							</p>
							<p class="card-text text-center">
								Status:
								<%=booksAdd.getStatus()%>
							</p>
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<h1 class="text-center"><%=booksAdd.getBookName()%></h1>
					<div class="text-center">
						<a href="#" style="font-size: 2em; text-decoration: none;">Contact
							to seller</a>
					</div>
					<div id="contact">
						<div class="cast">
							<a style="text-decoration: none;" href=""><i
								class="fa-solid fa-money-bill-1-wave" style="color: #ff0000;"></i>
								Cast on delivery</a>
						</div>
						<div class="re-avaiable">
							<a style="text-decoration: none;" href=""><i
								class="fa-solid fa-rotate-right" style="color: #ff0000;"></i>Return
								Avaiable</a>
						</div>
						<div class="freeship">
							<a style="text-decoration: none;" href=""> <i
								class="fa-solid fa-truck" style="color: #ff0000;"></i>Free Ship
							</a>
						</div>
					</div>
					
					<div class="text-center">
						<button class="btn btn-primary mt-2">
							<a href="add_cart?bookId=<%=bookId%>&&username=<%=username%>"
								class="text-white"><i class="fa-solid fa-store"></i>Add cart</a>
						</button>
					</div>
				</div>
			</div>
		</div>

	</section>


</body>
</html>