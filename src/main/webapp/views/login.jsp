<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body class=" bg-warning">
	<div class="container">
		<form class="mx-auto w-50 border  mt-5 p-5 bg-light" method="post"
			action="<%=request.getContextPath()%>/login">
			<h1 class="text-center mb-5">LOGIN</h1>
			<c:if test="${not empty message}">
				<h6 class="text-center text-primary">${message}</h6>
			</c:if>
			<div class="form-group row">
				<label class="col-sm-3 col-form-label font-weight-bold text-center">User
					Name: </label>
				<div class="col-sm-9">
					<input type="text" class="form-control" id="inputUserName"
						placeholder="Enter your User Name" name="user_name"
						required="required">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-3 col-form-label font-weight-bold text-center">Password:
				</label>
				<div class="col-sm-9">
					<input type="password" class="form-control" id="inputPassword"
						placeholder="Enter your Password" name="password"
						required="required">
				</div>
			</div>

			<div class="text-center mt-4 form-group row">
				<span class="mr-3 col-sm-12"><button type="submit"
						class="btn btn-warning mb-3 text-white">Login</button></span> <span
					class="mr-3 col-sm-12"><a href="<%=request.getContextPath()%>/views/register-user.jsp">Click
						here to Register</a></span>
			</div>
		</form>
		<c:if test="${not empty logout}">
			<script type="text/javascript">
				localStorage.removeItem("UserName");
			</script>
		</c:if>
	</div>

</body>
</html>