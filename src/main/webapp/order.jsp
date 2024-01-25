<%@page import="model.User"%>
<%@page import="model.Order"%>
<%@page import="dao.OrderDAOImpl"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="model.Cart"%>
<%@page import="java.util.List"%>
<%@page import="connectDB.DBConnect"%>
<%@page import="dao.CartDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_component/allCss.jsp"%>
</head>
<body>
	<%@include file="all_component/navbar.jsp"%>

	<c:if test="${not empty removev }">
		<h2 class='text-center text-danger'>${removev}</h2>
		<c:remove var="removev" scope='session' />
	</c:if>

	<section id="cart">
		<div class="container">
			<div class="row">
				<div class="col-md-12 bg-white">
					<h1 class="text-center">Your selected items</h1>
					<table class="table">
						<thead>
							<tr>
								<th scope="col">Book Name</th>
								<th scope="col">Author</th>
								<th scope="col">Price</th>
								<th scope="col">Payment</th>
								<th scope="col">Date</th>
							</tr>
						</thead>
						<tbody>
							<%
							String username = (String) session.getAttribute("username");
							OrderDAOImpl orderDAOImpl = new OrderDAOImpl(new DBConnect().getConn());
							List<Order> orderList = orderDAOImpl.getOrderByUserName(username);
							for (Order orderItem : orderList) {
							%>
							<tr>
								<th scope="row"><%=orderItem.getBookname()%></th>
								<td><%=orderItem.getAuthor()%></td>
								<td><%=orderItem.getPrice()%></td>
								<td><%=orderItem.getPayment()%></td>
								<td><%=orderItem.getDate()%></td>
							</tr>
							<%
							}
							%>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</section>
</body>
</html>