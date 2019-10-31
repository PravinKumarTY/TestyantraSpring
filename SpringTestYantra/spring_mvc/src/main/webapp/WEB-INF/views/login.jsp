
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="./login" method="post">
		<table>
			<tr>
				<td>Email</td>
				<td><input type="email" name="email" required="required"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" required="required"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Sign In"></td>
			</tr>
		</table>
	</form>
	<a href="./resgister">Sign UP</a>
	<h3>${msg}</h3>
</body>
</html>