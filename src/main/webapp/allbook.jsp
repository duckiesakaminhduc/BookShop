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

		<label style='margin-left: 120px' for='sort'>Sort by</label> <select
			id='sort'>
			<option selected>Default</option>
			<option>Ascending prices</option>
		</select>

		<%
		int total = new BookDAOImpl(new DBConnect().getConn()).getAllBook().size();
		%>
		<div class="container">
			<div class="row" id='content'>
				<%
				List<BooksAdd> recentBookList = new BookDAOImpl(new DBConnect().getConn()).getOnlyTop4();
				for (BooksAdd bookItem : recentBookList) {
				%>
				<div id='bookItem' class="col-md-3 text-center mb-1 ">
					<div class="card">
						<div class="card-body">
							<div class="text-center">
								<img src="image/<%=bookItem.getPhoto()%>" style="width: 150px;"
									class="img-thumbnail" alt="...">
							</div>
							<h5 class="card-title"><%=bookItem.getBookName()%></h5>
							<p class="card-text">Some quick example text to build on the
								card title and make up the bulk of the card's content.</p>

							<a href="view_book.jsp?bookId=<%=bookItem.getBookId()%>"
								class="btn btn-danger">View</a> <a
								href="add_cartt?bookId=<%=bookItem.getBookId()%>&&userName=<%=username%>"
								class="btn btn-success">Add Cart</a>
						</div>
					</div>
				</div>
				<%
				}
				%>
				<hr>

				<hr>
			</div>

			<hr>
			<input type='hidden' value=<%=4%> name='row' id='row'> <input
				type='hidden' value=<%=total%> id='total'>
			<div class='text-center'>
				<button id='load' class='btn btn-success'>Load more</button>
			</div>
		</div>
	</section>

	<!-- ================= ajax load more post =====================-->

	<!-- ================= ajax load add cart =====================-->




	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="all_component/main.js"></script>

</body>

</html>