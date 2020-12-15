<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to persons</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<a href="/persons/new">Add a new person</a>
		<a href="/licenses/new">Add a new license</a>
		
		
		<table class="table table-dark">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Rating</th>

					
					<th>Actions</th>
				</tr>
			</thead>
			
			<tbody>
				<!-- loop through arraylist -->
				<c:forEach items="${allDLs}" var="person">
					<tr>
						<td>${person.id}</td>
						<td><a href="/person/${person.id}">${person.firstName}</a></td>
						<td>${person.lastName}</td>
						
						<td><a href="/delete/${person.id }">Delete</a></td>
					</tr>
				
				</c:forEach>
			
			</tbody>
		
		
		
		
		
		
		</table>
	
	
	
	
	
	
	</div>
</body>
</html>