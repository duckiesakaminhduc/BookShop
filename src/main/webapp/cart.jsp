<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="model.Cart"%>
<%@page import="java.util.List"%>
<%@page import="connectDB.DBConnect"%>
<%@page import="dao.CartDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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

	<c:if test="${not empty order_suc }">
		<h2 class='text-center text-success'>${order_suc}</h2>
		<c:remove var="order_suc" scope='session' />
	</c:if>

	<section id="cart">
		<div class="container">
			<div class="row">
				<div class="col-md-6 bg-white">
					<h1 class="text-center">Your selected items</h1>
					<table class="table">
						<thead>
							<tr>
								<th scope="col">Book</th>
								<th scope="col">Author</th>
								<th scope="col">Price</th>
								<th scope="col">Action</th>
							</tr>
						</thead>
						<tbody>
							<%
							String username = (String) session.getAttribute("username");
							CartDAOImpl c = new CartDAOImpl(new DBConnect().getConn());
							List<Cart> cartList = c.getOrderByUsername(username);
							int total = 0;
							for (Cart cartItem : cartList) {
								float price = Float.parseFloat(cartItem.getPrice());
								total += price;
							%>
							<tr>
								<th scope="row"><%=cartItem.getBookName()%></th>
								<td><%=cartItem.getAuthor()%></td>
								<td><%=cartItem.getPrice()%></td>
								<td><%=cartItem.getBookId()%></td>

								<td><button username=<%=cartItem.getUserName()%>
										bookid=<%=cartItem.getBookId()%> "
									class="btn-del">Remove</button></td>
							</tr>
							<%
							}
							%>
						</tbody>
					</table>
				</div>

				<div class="col-md-6">
					<h1 class="text-center">Check out</h1>
					<form action="order" method='post'>
						<div class="form-row">
							<div class="form-group col-md-6">
								<label for="name">Name</label> <input type="text"
									class="form-control" id="username" name="name"
									value=<%=username%>>
							</div>
							<div class="form-group col-md-6">
								<label for="inputEmail4">Email</label> <input type="email"
									class="form-control" id="inputEmail4" name="email">
							</div>
						</div>
						<div class="form-group">
							<label for="inputAddress">Address</label> <input type="text"
								class="form-control" id="inputAddress"
								placeholder="1234 Main St" name="address">
						</div>
						<div class="form-row">
							<div class="form-group col-md-4">
								<label for="inputState">Payment selected</label> <select
									id="inputState" class="form-control" name="payment">
									<option selected>Choose...</option>
									<option value="Cash on Delivery">Cash on Delivery</option>
									<option value="Online payment">Online payment</option>
								</select>
							</div>
							<div class="form-group col-md-5">
								<label for="inputZip">Phone</label> <input type="text"
									class="form-control" id="inputZip" name='phone'>
							</div>
							<%
							java.util.Date currentTime = new java.util.Date();
							String currentTimeStr = currentTime.toString();
							%>
							<input type="hidden" name="date" value="<%=currentTimeStr%>">
						</div>

						<%
						List<Cart> cartList1 = c.getCartByUsername(username);
						String listProduct = "";
						for (Cart cartItem : cartList1) {
							listProduct += cartItem.getBookName() + ",";
						}
						%>
						<input type='hidden' name='listProduct' value=<%=listProduct%>>


						<button type='submit' class="btn btn-success">Order Now</button>
						<a href='index.jsp' class="btn btn-primary">Continue Shopping</a>
						<%

						%>
					</form>
				</div>
			</div>
		</div>
	</section>

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="all_component/main.js"></script>
	<script>
		$(document).ready(function() {
			$(".btn-del").click(function(e) {
				var username = $(this).attr("username");
				var bookid = $(this).attr("bookid");
				var row = $(this).closest('tr');
				$.ajax({
					url : "http://localhost:8080/BookShop/remove_cart",
					type : "GET",
					data : {
						username : username,
						bookid : bookid,
					},
					success : function(data) {
						if (data.status) {
							row.remove();
						}
					}
				})
			});
		});
	</script>



</body>
</html>