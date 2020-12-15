<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
			<!-- in order to use validations via JSTL -->
			<!DOCTYPE html>
			<html>

			<head>
				<meta charset="ISO-8859-1">
				<title>Add new License</title>
				<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
					rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
					crossorigin="anonymous">
			</head>

			<body>

				<div class="container">
					<h1>New License</h1>
					<a href="/dashboard">Dashboard</a>

					<form:form method="POST" action="/addLicense" modelAttribute="license">
						<div class="form-group row">
							<form:label path="person" class="col-sm-2 col-form-label">Person:
								<form:errors path="person" />
								<div class="col-sm-10">
									<select class="form-control" name="person" path="person">
										<c:forEach items="${allPersons}" var="person">
											<option value="${person.id}">${person.firstName} ${person.lastName}</option>								
										</c:forEach>
									</select>
									<!-- <form:input path="state" class="form-control" />	 -->
								</div>
							</form:label>
						</div>

						<div class="form-group row">
							<form:label path="state" class="col-sm-2 col-form-label">State:
								<form:errors path="state" />
								<div class="col-sm-10">
									<form:input path="state" class="form-control" />
								</div>
							</form:label>
						</div>
						<div class="form-group row">
							<form:label path="expirationDate" class="col-sm-2 col-form-label">Expiration Date:
								<form:errors path="expirationDate" />
								<div class="col-sm-10">
									<form:input type="date" path="expirationDate" class="form-control" />
								</div>
							</form:label>
						</div>


						<button>Create</button>

					</form:form>

				</div>


			</body>

			</html>