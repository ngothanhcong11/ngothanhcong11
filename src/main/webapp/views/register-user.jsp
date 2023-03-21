<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<!DOCTYPE html>
<html>
<head>
<meta content="UTF-8">

<title>Register User</title>
</head>
<body class="bg-warning">
	<div class="container text-center">
		<form action="<%=request.getContextPath()%>/register" method="post"
			onsubmit="return validateRegister()" name="frm-register" 
			class="w-75 mx-auto bg-light p-5 pt-2 mt-5">
			<h1 class="mt-3 mb-5">REGISTER USER</h1>
			<%
			String message = (String) request.getAttribute("message");
			%>
			<%
			if (message == null) {
				message = "";
			}
			%>
			<p class="text-danger"><%=message%></p>
			<div class="mb-3 form-group row">
				<label class="form-label col-2">First Name</label> <input
					type="text" class="col-10" name="firstName" id="firstName"
					placeholder="Enter first name" />
			</div>

			<div class="mb-3 form-group row">
				<label class="form-label col-2">Last Name</label> <input type="text"
					class="col-10" name="lastName" class="lastName" id="lastName"
					placeholder="Enter last name" />
			</div>

			<div class="mb-3 form-group row">
				<label class="form-label col-2">Email</label> <input type="email"
					class="col-10" name="email" id="email" placeholder="Enter email" />
			</div>

			<div class="mb-3 form-group row">
				<label class="form-label col-2">User Name</label> <input type="text"
					class="col-10" name="userName" id="userName"
					placeholder="Enter user name" />
			</div>

			<div class="mb-3 form-group row">
				<label class="form-label col-2">Password</label> <input
					type="password" class="col-10" name="password" id="password"
					placeholder="Enter password" />
			</div>

			<div class="mb-3 form-group row">
				<label class="form-label col-2">Confirm Password</label> <input
					class="col-10" type="password" name="confirmPassword"
					id="confirmPassword" placeholder="Enter password again" />
			</div>

			<button type="submit" class="btn btn-warning mr-5">Submit</button>
			<a href="<%=request.getContextPath()%>/views/login.jsp"
				class="btn btn-secondary">Back</a>
		</form>

	</div>
	<script
		src="<%=request.getContextPath()%>/resources/js/register-user.js"></script>
</body>

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>
</html>
