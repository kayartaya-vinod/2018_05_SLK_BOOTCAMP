<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello JSP</title>
</head>
<body>
	<h1>Hello JSP!</h1>
	<hr>
	<p>Greetings from Vinod</p>
	<%
		// This is where you can write Java code
		for(int i=1; i<=6; i++) {
			out.println("<h" + i + ">This is heading-" + i + "</h" + i + ">");
		}
	%>
</body>
</html>