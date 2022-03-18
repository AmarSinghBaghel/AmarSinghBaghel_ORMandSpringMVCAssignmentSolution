<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Save Student</title>
<style>
h3 {
	background-color: lightgreen;
	text-align: center;
}
</style>
</head>

<body>

	<div class="container">

		<h3>Customer Relationship Management</h3>
		<hr>

		<p class="h4 mb-4">Save Customer</p>

		<form action="/web-customer-tracker2/customer/save" method="POST">

			<!-- Add hidden form field to handle update -->
			<input type="hidden" name="id" value="${Customer.id}" />

			<div class="form-inline">
				<a class="h4 mb-4"> First Name : &nbsp; &nbsp; </a> <input
					type="text" name="firstName" value="${Customer.firstname}"
					class="form-control mb-4 col-4" placeholder="FristName">


			</div>



			<div class="form-inline">
				<a class="h4 mb-4">Last Name : &nbsp; &nbsp; </a> <input type="text"
					name="lastName" value="${Customer.lastname}"
					class="form-control mb-4 col-4" placeholder="LastName">

			</div>


			<div class="form-inline">
				<a class="h4 mb-4"> Email ID :&nbsp; &nbsp;&nbsp; </a> <input
					type="text" name="course" value="${Customer.email}"
					class="form-control mb-4 col-4" placeholder="Email">
			</div>

			<button type="submit" class="btn btn-info col-2">Save</button>

		</form>

		<hr>
		<a href="/web-customer-tracker2/customer/list">Back to Students
			List</a>

	</div>
</body>

</html>