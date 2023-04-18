<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Report Application</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<style type="text/css">
body {
	
}

.container {
	
}

td {
	
}
</style>
</head>
<body>
	<div class="container">
		<h2 style="text-align: center;">Search Here</h2>
		<form:form action="search" method="post"
			modelAttribute="searchRequest">


			<table class="table table-striped">

				<tr>

					<td>Plan Name: <form:select path="planName">
							<form:option value="" label="-select-" />
							<form:options items="${planItems}" />
						</form:select>
					</td>
					<td>Plan Status: <form:select path="planStatus">
							<form:option value="" label="-select-" />
							<form:options items="${ statusItems}" />
						</form:select>
					</td>
					<td>Plan Gender: <form:select path="gender">
							<form:option value="" label="-select-" />
							<form:option value="male" label="male" />
							<form:option value="Fe-male" label="Fe-male" />
						</form:select>
					</td>
				</tr>
				<tr>
					<td>Start Date: <input type="date" name="startDate">
					</td>
					<td>End Date: <input type="date" name="endDate">
					</td>
				</tr>
				<tr>
					<td><a class="btn btn-secondary" href="/">reset</a></td>
					<td><input class="btn btn-primary" type="submit"
						value="search"></td>
				</tr>
			</table>


		</form:form>

		<br> <br>

		<h2 style="text-align: center;">Reports</h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Citizen Id</th>
					<th>citizenName</th>
					<th>gender</th>
					<th>planName</th>
					<th>planStatus</th>
					<th>planStartDate</th>
					<th>planEndDate</th>
					<!-- <th>benefitAmount</th>
					<th>denialReason</th>
					<th>terminatedDate</th>
					<th>terminationReason</th> -->
				</tr>
			</thead>
			<tbody>

				<c:forEach var="r" items="${report}">
					<tr>
						<td>${r.citizenId }</td>
						<td>${r.citizenName }</td>
						<td>${r.gender }</td>
						<td>${r.planName }</td>
						<td>${r.planStatus }</td>
						<td>${r.planStartDate }</td>
						<td>${r.planEndDate }</td>
						<%-- <td>${r.benefitAmount }</td>
						<td>${r.denialReason }</td>
						<td>${r.terminatedDate }</td>
						<td>${r.terminationReason }</td> --%>

					</tr>

				</c:forEach>
				<tr>
					<c:if test="${empty report}">
						<td colspan="7" style="text-align: center;">No records found</td>
					</c:if>
				</tr>


			</tbody>

		</table>

		<hr>
		<table>
			<tr>
				<td>Export :</td>
				<td><a href="excel" class="btn btn-dark">Excel</a></td>
				<td><a href="pdf" class="btn btn-dark">PDF</a></td>
			</tr>

		</table>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>


</body>
</html>