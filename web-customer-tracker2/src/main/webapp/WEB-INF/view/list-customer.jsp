<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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

<title>Customer Relationship Management</title>
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


		<!-- Add a button -->
		<a href="/web-customer-tracker2/customer/showFormForAdd"
			class="btn btn-primary btn-sm mb-3"> Add Student </a>




		</form>

		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>Sr No.</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
			</thead>
			<%!int i = 1;%>
			<tbody>
				<c:forEach items="${Customer}" var="tempCustomer">

					<tr>
						<td><%=i%> <%
 i++;
 %></td>
						<td><c:out value="${tempCustomer.firstname}" /></td>
						<td><c:out value="${tempCustomer.lastname}" /></td>
						<td><c:out value="${tempCustomer.email}" /></td>
						<td>
							<!-- Add "update" button/link --> <a
							href="/web-customer-tracker2/customer/showFormForUpdate?customerId=${tempCustomer.id}"
							class="btn btn-info btn-sm"> Update </a> <!-- Add "delete" button/link -->
							<a
							href="/web-customer-tracker2/customer/delete?customerId=${tempCustomer.id}"
							class="btn btn-danger btn-sm"
							onclick="if (!(confirm('Are you sure you want to delete this Student?'))) return false">
								Delete </a>

						</td>

					</tr>
				</c:forEach>
				<%
				i = 1;
				%>
			</tbody>
		</table>

	</div>

</body>
</html>
© 2022 GitHub, Inc. Terms
