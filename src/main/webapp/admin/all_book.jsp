 <%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="model.BooksAdd"%>
<%@page import="java.util.List"%>
<%@page import="connectDB.DBConnect"%>
<%@page import="dao.BookDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="../all_component/allCss.jsp"%>

</head>
<body>
	<%@include file="header.jsp"%>

	<%
	BookDAOImpl bookDAOImpl = new BookDAOImpl(new DBConnect().getConn());
	bookDAOImpl.getAllBook();
	List<BooksAdd> bookList = bookDAOImpl.getAllBook();
	%>
	<section id="order_book">
		<h1 class="text-center">Order Book</h1>

		<c:if test="${not empty yess }">
			<h2 class='text-center text-success'>${yess}</h2>
			<c:remove var="yess" scope='session' />
		</c:if>


		<c:if test="${not empty delete }">
			<h2 class='text-center text-success'>${delete}</h2>
			<c:remove var="delete" scope='session' />
		</c:if>
		
		<table class="table text-center">
			<thead class="bg-primary text-light">
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Book name</th>
					<th scope="col">Athor</th>
					<th scope="col">Price</th>
					<th scope="col">Category</th>
					<th scope="col">Status</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (BooksAdd bookItem : bookList) {
				%>
				<tr>
					<th scope="row"><%=bookItem.getBookId()%></th>
					<td><%=bookItem.getBookName()%></td>
					<td><%=bookItem.getAuthor()%></td>
					<td><%=bookItem.getPrice()%></td>
					<td><%=bookItem.getBookCategory()%></td>
					<td><%=bookItem.getStatus()%></td>
					<td><a href="edit_book.jsp?bookId=<%=bookItem.getBookId()%>"
						class="btn bg-success text-light">Edit</a> <a
						href="../delete_book?bookId=<%=bookItem.getBookId()%>"
						class="btn bg-danger text-light">Delete</a></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</section>

</body>
</html>