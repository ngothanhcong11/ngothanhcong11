<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.10.3/font/bootstrap-icons.min.css"
	integrity="sha512-YFENbnqHbCRmJt5d+9lHimyEMt8LKSNTMLSaHjvsclnZGICeY/0KYEeiHwD1Ux4Tcao0h60tdcMv+0GljvWyHg=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-warning fixed-top">
		<a class="navbar-brand text-white ml-3"
			href="<%=request.getContextPath()%>/HomePage"><i
			class="bi bi-house-door-fill text-white mr-1"></i>Home Page</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse mr-3" id="navbarSupportedContent">
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
	<div class="mt-5 pt-5 ">
		<h3 class="d-flex justify-content-center">Add Employee</h3>
		<c:if test="${not empty alert}">
			<h6 class="text-center text-primary">${alert}</h6>
		</c:if>
		<form class="mt-3 w-75 mx-auto col-lg-5" name="form-detail-user"
			action="<%=request.getContextPath()%>/AddEmployee" method="POST">
			<div class="mb-3">
				<label class="form-label ">Name:</label> <input type="text"
					class="form-control" name="full_name" required pattern="[a-zA-z\s]{5,50}" title="Please input full name!"
					placeholder="Enter name">
			</div>

			<div class="mb-3">
				<label class="form-label">Gender: </label>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="gender"
						value="1"> <label class="form-check-label"
						for="flexRadioDefault1"> Male </label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="gender" checked
						value="2"> <label class="form-check-label"
						for="flexRadioDefault2"> Female </label>
				</div>
			</div>
			<div class="row form-group mb-3">
				<label class="col-4">Date of Birth: </label>
				<div class="col-8">
					<div class="input-group date" id="datepicker">
						<input type="date" class="form-control" name="DOB" id="DOB"
							required="required" min="1970-01-01" > <span
							class="input-group-append"> </span>
					</div>
				</div>
			</div>
			<div class="row form-group mb-3">
				<label class="col-4">Department:</label>
				<div class="col-8">
					<select class="form-select w-100 border p-2 rounded"
						name="department">
						<c:forEach var="department" items="${listDepartment}">
							<option value="${department.getID()}">${department.getName()}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<button type="submit" class="btn btn-warning mt-2 text-white "
				onclick="return validateDate()">Add Employee</button>
		</form>
	</div>
	<div class="footer fixed-bottom bg-warning text-center text-white p-3">
		@ Copyright R2S Academy 2022</div>
		
		
	<script
		src="<%=request.getContextPath()%>/resources/js/add-employee.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"
		integrity="sha512-STof4xm1wgkfm7heWqFJVn58Hm3EtS31XFaagaa8VMReCXAkQnJZ+jEy8PCC/iT18dFy95WcExNHFTqLyp72eQ=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script type="text/javascript">
		$(function() {
			$('[data-toggle="popover"]').popover()
		})
	</script>
	<script type="text/javascript">
		var userName = localStorage.getItem("UserName");
		document.getElementById("show-user-name").innerHTML = userName
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