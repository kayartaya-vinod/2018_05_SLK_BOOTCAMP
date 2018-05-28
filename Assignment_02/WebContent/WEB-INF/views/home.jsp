<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Assignment 2 - Person Manager</title>
<style>
	#f1 > div > label {
		display: inline-block;
		width: 150px;
	}
	
	input[type=text] {
		padding: 5px;
	}
	
	#f1 > div {
		padding: 5px;
	}
	
	button {
		padding: 5px;
	}
</style>
</head>
<body>
	<h1>Assignment 2 - Person Manager</h1>
	<hr >
	<h3>Add person details</h3>
	
	<form action="./add-person" id="f1" method="POST">
		<input type="hidden" name="id" value="${person.id}">
		<div>
			<label for="firstname">Firstname</label>
			<input type="text" id="firstname" name="firstname" 
				placeholder="enter firstname" >
		</div>
		
		<div>
			<label for="lastname">Lastname</label>
			<input type="text" id="lastname" name="lastname" 
				placeholder="enter lastname" >
		</div>
		
		<div>
			<label for="email">Email address</label>
			<input type="text" id="email" name="email" size="50" 
				placeholder="enter email" >
		</div>
		
		<div>
			<label for="phone">Phone number</label>
			<input type="text" id="phone" name="phone" size="30" 
				placeholder="enter phone" >
		</div>
		
		<div>
			<label></label>
			<button>Save details</button>
		</div>
	</form>
	
	
	<jsp:include page="/list-all-contacts" />
	
	<script>
		document.getElementById("firstname").focus();
	</script>
</body>
</html>













