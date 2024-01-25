<%@page import="connectDB.DBConnect"%>
<%@page import="dao.OrderDAOImpl"%>
<%@page import="model.Order"%>
<%@page import="java.util.List"%>
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
	<%@include file="header.jsp"%>
	<section id="order_book">
		<h1 class="text-center">Order Book</h1>
		<table class="table text-center">
			<thead class="bg-primary text-light">
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Email</th>
					<th scope="col">Address</th>
					<th scope="col">Phone</th>
					<th scope="col">Book Name</th>
					<th scope="col">Author</th>
					<th scope="col">Price</th>
					<th scope="col">Payment type</th>
					<th scope="col">Date</th>
				</tr>
			</thead>
			<tbody>
				<%
				OrderDAOImpl orderDAOImpl = new OrderDAOImpl(new DBConnect().getConn());
				List<Order> orderList = orderDAOImpl.getAllOrder();
				for (Order orderItem : orderList) {
				%>
				<tr>
					<th scope="row"><%=orderItem.getUsername()%></th>
					<td><%=orderItem.getEmail()%></td>
					<td><%=orderItem.getAddress()%></td>
					<td><%=orderItem.getPhone()%></td>
					<td><%=orderItem.getBookname()%></td>
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
	</section>

</body>
</html>