<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"  %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Session Demo</title>
</head>
<body>
	<h1>Session Demo</h1>
	<hr>
	
	<form action="./store-name" method="POST">
		<label>Enter name of a friend: </label>
		<input type="text" name="friend_name">
		<button>Store in server</button>
	</form>
	
	<div>
		<a href="./clear-all-names">Clear all names</a>
	</div>
	
	<jsp:include page="./list-names.jsp" />
	
	<script>
	document.querySelector("input[name=friend_name]").focus();
	</script>
</body>
</html>






