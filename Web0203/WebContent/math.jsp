<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Math</title>
</head>
<body>
	<%
		String errorA = "";
		if (request.getAttribute("errorA") != null) {
			errorA = (String) request.getAttribute("errorA");
		}
		String errorB = "";
		if (request.getAttribute("errorB") != null) {
			errorB = (String) request.getAttribute("errorB");
		}
		String errorC = "";
		if (request.getAttribute("errorC") != null) {
			errorC = (String) request.getAttribute("errorC");
		}
		String a;
		String b;
		int c;
		if (request.getAttribute("parameterA") != null) {
			a = (String) request.getAttribute("parameterA");
		} else {
			a = "0";
		}
		if (request.getAttribute("parameterB") != null) {
			b = (String) request.getAttribute("parameterB");
		} else {
			b = "0";
		}
		if (request.getAttribute("c") != null) {
			c = (Integer) request.getAttribute("c");
		} else {
			c = 0;
		}
	%>
	<form action="../Web0203/math" method="post">
	a: <input type="text" id='a' name='a' value='<%=a%>' />
	<br>
	<%=errorA%>
	<br> b:
	<input type="text" id='b' name='b' value='<%=b%>' />
	<br>
	<%=errorB%>
	<br>
	c:
	<input type="text" id='c' name='c' value='<%=c%>' />
	<br>
	<%=errorC%>
	<br>
	<input type="submit" id='operation' value='plus' name = 'add'/> 
	<input type="submit" id='operation' value='minus' name = 'substract'/>
	</form>
</body>
</html>