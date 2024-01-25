<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="all_component/style.css">

<title>Insert title here</title><%@include
	file="all_component/allCss.jsp"%>

</head>
<body>
	<%@include file="all_component/navbar.jsp"%>
	<section id="register">
		<h1 class="text-center text-light">Registration</h1>
		<div class="container bg-light">

			<form action='register' method='post'>
				<div class="form-group">
					<label for="username">Username</label> <input id="user" type="text"
						class="form-control" id="username" name='username'> <small
						class="form-text text-muted">username</small>

				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">Email address</label> <input
						id="email" type="email" class="form-control"
						id="exampleInputEmail1" aria-describedby="emailHelp" name='email'>
					<small class="form-text text-muted">email</small>
				</div>

				<div class="form-group">
					<label for="exampleInputPassword1">Password</label> <input
						id="pass" type="password" class="form-control"
						id="exampleInputPassword1" name='password'> <small
						class="form-text text-muted">password</small>

				</div>
				<div class="form-group">
					<label for="phone">Phone</label> <input id="number" type="text"
						class="form-control" id="phone" name='phone'><small
						class="form-text text-muted">phone</small>
				</div>

				<div class="form-group form-check">
					<input type="checkbox" class="form-check-input" id="exampleCheck1">
					<label class="form-check-label" for="exampleCheck1">Check
						me out</label>

				</div>
				<div class="text-center">
					<button type='submit' class="bg-primary mb-2 text-light">Register</button>
				</div>
			</form>


		</div>

	</section>

	<script>
		const user = document.getElementById('user');
		const email = document.getElementById('email');
		const pass = document.getElementById('pass');
		const number = document.getElementById('number');

		user.addEventListener('change', checkValidate);
		email.addEventListener('change', checkEmail);
		pass.addEventListener('change', checkValidate);
		number.addEventListener('input', checkNumber);

		function checkValidate() {
			const userVal = user.value.trim();
			const emailVal = email.value.trim();
			const passVal = pass.value.trim();
			const numberVal = number.value.trim();

			if (userVal === "") {
				setError(user, "Không được để trống");
			} else {
				clearError(user);
			}

			if (emailVal === "") {
				setError(email, "Không được để trống");
			} else {
				clearError(email);
			}

			if (passVal === "") {
				setError(pass, "Không được để trống");
			} else {
				clearError(pass);
			}

			if (numberVal === "") {
				setError(number, "Không được để trống");
			} else {
				clearError(number);
			}
		}

		function checkEmail() {
			const emailVal = email.value.trim();
			const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

			if (!emailPattern.test(emailVal)) {
				setError(email, "Vui lòng nhập đúng định dạng email");
			} else {
				clearError(email);
			}
		}

		function checkNumber() {
			const numberVal = number.value.trim();
			const numberPattern = /^\d+$/;
			if (!numberPattern.test(numberVal)) {
				setError(number, "Vui lòng chỉ nhập số");
			} else {
				clearError(number);
			}
		}

		function setError(ele, mess) {
			const eleParent = ele.parentNode;
			eleParent.querySelector("small").innerText = mess;
		}

		function clearError(ele) {
			const eleParent = ele.parentNode;
			eleParent.querySelector("small").innerText = "";
		}
	</script>
	<script src="all_component/main.js"></script>

</body>
</html>