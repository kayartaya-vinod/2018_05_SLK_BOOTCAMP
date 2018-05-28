<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${fn:length(persons)>0}">
	<h3>Details of your contact are...</h3>

	<table border="1">
		<thead>
			<tr>
				<th>Name</th>
				<th>Phone number</th>
				<th>Email address</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${persons}" var="p">
				<tr>
					<td>${p.firstname} ${p.lastname}</td>
					<td>${p.phone}</td>
					<td>${p.email}</td>
					<td>
					<a href="./edit-person?id=${p.id}">Edit</a> | 
					<a href="./delete-person?id=${p.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>