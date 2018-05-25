<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contact List</title>

<style>
	table tr>td, table tr>th {
		padding: 7px;
		border: 1px solid #777;
	}
	table {
		border-collapse: collapse;
	}
	table tr>th {
		background-color: #eee;
	}
</style>

</head>
<body>
	<h1>${requestScope.heading}</h1>
	
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Phone</th>
				<th>City</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${contacts}" var="c">
			<tr>
				<td>${c.gender=="Male"?"Mr.":"Ms."}  ${c.firstname} ${c.lastname}</td>
				<td>${c.email }</td>
				<td>${c.phone }</td>
				<td>${c.city }</td>
				<td>
					<a href="">Edit</a> |
					<a href="delete-contact?id=${c.id}">Delete</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>