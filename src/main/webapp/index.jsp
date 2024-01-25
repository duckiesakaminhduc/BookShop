<%@page import="model.User"%>
<%@page import="dao.UserDAOImpl"%>
<%@page import="dao.UserDAO"%>
<%@page import="model.BooksAdd"%>
<%@page import="java.util.List"%>
<%@page import="dao.BookDAOImpl"%>
<%@page import="dao.BookDAO"%>
<%@page import="connectDB.DBConnect"%>
<%@page import="java.sql.Connection"%>
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




	<section id="banner">
		<div class="banner-img">
			<h2 class="text-white text-center font-italic text-light pt-2">"Nature
				and books belong to the eyes that see them"</h2>
		</div>

	</section>
	<!--  -->


	<section id="all-book">
		<h2 class="text-center font-weight-bold">All book</h2>

		<div class="container">
			<div class="row" id='content'>

				<%
				int total = new BookDAOImpl(new DBConnect().getConn()).getAllBook().size();
				List<BooksAdd> recentBookList = new BookDAOImpl(new DBConnect().getConn()).getOnlyTop4();
				for (BooksAdd bookItem : recentBookList) {
				%>
				<div class="col-md-3 text-center mb-1 ">
					<div class="card">
						<div class="card-body">
							<div class="text-center">
								<img src="image/<%=bookItem.getPhoto()%>" style="width: 150px;"
									class="img-thumbnail" alt="...">
							</div>
							<h5 class="card-title"><%=bookItem.getBookName()%></h5>
							<p class="card-text">Some quick example text to build on the
								card title and make up the bulk of the card's content.</p>
							<p>
								<span>Price :</span><%=bookItem.getPrice()%></p>
							<a href="view_book.jsp?bookId=<%=bookItem.getBookId()%>"
								class="btn btn-danger">View</a>
							<button class='add btn btn-success'>Add Cart</button>
							<input type='hidden' class='bookId'
								value=<%=bookItem.getBookId()%>> <input type='hidden'
								class='username' value=<%=username%>>
						</div>
					</div>
				</div>
				<%
				}
				%>
			</div>
			<input type='hidden' value=<%=4%> name='row' id='row'> <input
				type='hidden' value=<%=total%> id='total'>
			<div class='text-center'>
				<button id='load' class='btn btn-success text-center'>Load
					more</button>
			</div>

		</div>
	</section>
	</div>
	</section>

	<!-- ================= ajax load more post =====================-->

	<!-- ================= ajax load add cart =====================-->


	<!-- =======================OLD BOOK============================================== -->

	<section id="new-book">
		<h2 class="text-center font-weight-bold">Old book</h2>

		<div class="container">
			<div class="row">
				<%
				List<BooksAdd> oldBookList = new BookDAOImpl(new DBConnect().getConn()).getOldBook();
				for (BooksAdd bookItem : oldBookList) {
				%>
				<div class="col-md-3 text-center mb-1">
					<div class="card">
						<div class="card-body">
							<div class="text-center">
								<img src="image/<%=bookItem.getPhoto()%>" style="width: 150px;"
									class="img-thumbnail" alt="...">
							</div>
							<h5 class="card-title"><%=bookItem.getBookName()%></h5>
							<p class="card-text">Some quick example text to build on the
								card title and make up the bulk of the card's content.</p>
							<%
							if (username != null) {
							%>
							<a href="view_book.jsp?bookId=<%=bookItem.getBookId()%>"
								class="btn btn-danger">View</a> <a
								href="add_cartt?bookId=<%=bookItem.getBookId()%>&&userName=<%=username%>"
								class="btn btn-success">Add Cart</a>
							<%
							} else {
							%>
							<a href="login.jsp" class="btn btn-danger">View</a> <a href="#"
								class="btn btn-success">Add Cart</a>
							<%
							}
							%>

						</div>
					</div>
				</div>
				<%
				}
				%>

				<hr>
			</div>
			<hr>
	</section>


	<!-- =============================NEW BOOK===================================== -->

	<section id="new-book">
		<h2 class="text-center font-weight-bold">New book</h2>

		<div class="container">
			<div class="row">
				<%
				List<BooksAdd> newBookList = new BookDAOImpl(new DBConnect().getConn()).getNewBook();
				for (BooksAdd bookItem : newBookList) {
				%>
				<div class="col-md-3 text-center mb-1">
					<div class="card">
						<div class="card-body">
							<div class="text-center">
								<img src="image/<%=bookItem.getPhoto()%>" style="width: 150px;"
									class="img-thumbnail" alt="...">
							</div>
							<h5 class="card-title"><%=bookItem.getBookName()%></h5>
							<p class="card-text">Some quick example text to build on the
								card title and make up the bulk of the card's content.</p>
							<%
							if (username != null) {
							%>
							<a href="view_book.jsp?bookId=<%=bookItem.getBookId()%>"
								class="btn btn-danger">View</a> <a
								href="add_cartt?bookId=<%=bookItem.getBookId()%>&&userName=<%=username%>"
								class="btn btn-success">Add Cart</a>
							<%
							} else {
							%>
							<a href="login.jsp" class="btn btn-danger">View</a> <a href="#"
								class="btn btn-success">Add Cart</a>
							<%
							}
							%>

						</div>
					</div>
				</div>
				<%
				}
				%>
			</div>
	</section>


	<!-- =============================NEW BOOK===================================== -->



	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="all_component/main.js"></script>

</body>

</html>