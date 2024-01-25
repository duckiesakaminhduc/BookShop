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

	<!-- =============================NEW BOOK===================================== -->

	<section id="new-book">
		<h2 class="text-center font-weight-bold">Search book</h2>

		<div class="container">
			<div class="row">
				<%
				String ch = request.getParameter("ch");
				List<BooksAdd> newBookList = new BookDAOImpl(new DBConnect().getConn()).searchBook(ch);

				for (BooksAdd bookItem : newBookList) {
				%>
				<div class="col-md-3 text-center">
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
	</section>
</body>

</html>