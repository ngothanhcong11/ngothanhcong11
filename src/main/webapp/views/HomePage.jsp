<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.10.3/font/bootstrap-icons.min.css"
	integrity="sha512-YFENbnqHbCRmJt5d+9lHimyEMt8LKSNTMLSaHjvsclnZGICeY/0KYEeiHwD1Ux4Tcao0h60tdcMv+0GljvWyHg=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-warning fixed-top">
		<a class="navbar-brand text-white" href="#"><i
			class="bi bi-house-door-fill text-white mr-1"></i>Home Page</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item "><a class="nav-link text-white ml-2"
					href="<%=request.getContextPath()%>/AddEmployee">Add</a></li>
				<li class="nav-item"><a class="nav-link text-white ml-2"
					href="<%=request.getContextPath()%>/ListEmployee">List</a></li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item">
					<i class="bi bi-person-circle text-white "></i>
					<span id="show-user-name" class="text-white"></span>
					</li>
				</ul>
			</form>
			<button type="button" class="btn btn-warning text-white pl-0 ml-2"
				data-container="body" data-toggle="popover" data-placement="bottom"
				data-trigger="focus" data-html="true"
				data-content="<a href='<%=request.getContextPath()%>/Logout' >Logout</a>">
				<i class="bi bi-box-arrow-right text-white mr-1"></i>Logout
			</button>
		</div>
	</nav>
	<div class="container mt-5 pt-5 text-center">
		<h3>Welcome to Employee Management System</h3>
	</div>
	<input id="user-name" class="d-none" value="<c:out value="${Username}"></c:out>"/>
	<div class="footer fixed-bottom bg-warning text-center text-white p-3">
		@ Copyright R2S Academy 2022</div>
		
	<c:if test="${not empty Username}">
		<script type="text/javascript">
		var username = document.getElementById("user-name").value;
		localStorage.setItem("UserName", username);
		</script>
	</c:if>
	<script type="text/javascript">
		var userName = localStorage.getItem("UserName");
		document.getElementById("show-user-name").innerHTML = userName
	</script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"
		integrity="sha512-STof4xm1wgkfm7heWqFJVn58Hm3EtS31XFaagaa8VMReCXAkQnJZ+jEy8PCC/iT18dFy95WcExNHFTqLyp72eQ=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script type="text/javascript">
		$(function() {
			$('[data-toggle="popover"]').popover()
		})
	</script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>