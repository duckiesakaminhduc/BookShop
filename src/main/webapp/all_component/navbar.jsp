<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section id="nav-login-register" class="p-4">
	<div class="row justify-content-between  align-items-center">
		<h1>Ebook Shop</h1>
		<form class="form-inline my-2 my-lg-0" action='search.jsp'
			method='post'>
			<input class="form-control mr-sm-2" type="search"
				placeholder="Search" aria-label="Search" name='ch'>
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		</form>


		<c:if test="${not empty username }">
			<div class="button-log">
				<a href="cart.jsp" class="btn" type="submit"> <i
					class="fa-solid fa-cart-shopping fa-xl" style="color: #005eff;"></i></a>
				<a class="btn btn-primary" type="submit">${username}</a> <a
					href="log_out" class="btn btn-success" type="submit">Log out</a>
			</div>
		</c:if>

		<c:if test="${empty username }">
			<div class="button-log">
				<a href="login.jsp" class="btn btn-primary" type="submit">Login</a>
				<a href="register.jsp" class="btn btn-success" type="submit">Register</a>
			</div>
		</c:if>


	</div>

	</div>


</section>


<!--  -->
<section id="nav-bar" class="bg-light">
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<a class="navbar-brand" href="index.jsp">Ebook Shop</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse font-weight-bold"
			id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto ">
				<li class="nav-item"><a class="nav-link" href="allbook.jsp">All
						book <span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Old book</a>
				</li>

				<li class="nav-item"><a class="nav-link" href="#">New Book</a>
				</li>
			</ul>

			<c:if test="${not empty username }">
				<div class="button-log">
					<a href="setting.jsp" class="btn btn-success"> <i
						class="fa-solid fa-house"></i> Setting
					</a>
				</div>
			</c:if>

			<c:if test="${empty username }">
				<div class="button-log">
					<a href="login.jsp" class="btn btn-success"> <i
						class="fa-solid fa-house"></i> Setting
					</a>
					<button class="btn btn-info" type="submit">
						<i class="fa-solid fa-right-from-bracket"></i> Contact us
					</button>
				</div>
			</c:if>
		</div>
	</nav>
</section>

<%
// Disable caching
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>