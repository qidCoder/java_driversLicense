<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%><!-- in order to use validations via JSTL -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Person</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
</head>
<body>

	<div class="container">
		<h1>${person.firstName} ${person.lastName}</h1>
		<a href="/dashboard">Dashboard</a>
		<hr>
		
<table class="table table-dark">

			
			<tbody>

					<tr>
						<td>License Number:</td>
						<td>${person.license.number}</td>
					</tr>
					<tr>
						<td>State:</td>
						<td>${person.license.state}</td>
					</tr>					
					<tr>
						<td>Expiration Date:</td>
						<td>${person.license.formatDate()}</td>
					</tr>
					<tr>
						<td><a href="/delete/${person.id}">Delete</a></td>
					</tr>
					

			
			</tbody>
		
		
		
		
		
		
		</table>	
		

			
	</div>


</body>
</html>