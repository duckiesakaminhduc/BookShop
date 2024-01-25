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
	<div class="container bg-light">
		<div class="row">
			<div class="col-md-12">
				<section id="add_book">
					<h1 class="text-center text-dark">Book Add</h1>
					<c:if test="${not empty yess }">
						<h2 class='text-center text-success'>${yess}</h2>
						<c:remove var="yess" scope='session' />
					</c:if>
					<div class="container bg-light">

						<form action='../add_book' method='post'
							enctype='multipart/form-data'>
							<div class="form-group">
								<label for="bookname">Book name</label> <input type="text"
									class="form-control" id="bookname" name='bookName'>
							</div>
							<div class="form-group">
								<label for="authorname">Athor name</label> <input type="text"
									class="form-control" id="authorname" name='authorName'>
							</div>
							<div class="form-group">
								<label for="price">Price</label> <input type="text"
									class="form-control" id="price" name='price'>
							</div>
							<div class="form-group">
								<label for="">Book Category</label> <select id=""
									class="form-control" name='bookCategory'>
									<option selected>Choose...</option>
									<option value='Fantasy'>Fantasy</option>
									<option value='Adventure'>Adventure</option>
									<option value='Romance'>Romance</option>
									<option value='Mystery'>Mystery</option>
									<option value='Thriller'>Thriller</option>
								</select>
							</div>
							<div class="form-group">
								<label for="bookstatus">Book Status</label> <select
									id="bookstatus" class="form-control" name='bookStatus'>
									<option selected>Choose...</option>
									<option value='New book'>New book</option>
									<option value='Old Book'>Old book</option>
								</select>
							</div>


							<div class="form-group">
								<label for="bfile">Example file input</label> <input type="file"
									class="form-control-file" id="bfile" name='bfile'>
							</div>

							<div class="text-center">
								<button type='submit' class="btn bg-primary mb-2 text-light"
									value='submit'>ADD</button>
							</div>


						</form>
					</div>

				</section>
			</div>
		</div>
	</div>
</body>
</html>