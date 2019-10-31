<%@page import="com.tyss.springmvc.dto.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	List<Employee> employees = (List) request.getAttribute("list");
	Employee emp = (Employee) session.getAttribute("emp");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="right">
		<span><a href="./update">Update profile</a></span> <span><a
			href="./delete?id=<%=emp.getId()%>">Delete profile</a></span> <span><a
			href="./logout">Logout</a></span>
	</div>
	<div>
		<a href="./home">Home</a>
	</div>
	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>DOB</th>
			<th>EMAIL</th>
		</tr>
		<%
			for (Employee emloyee : employees) {
		%>
		<tr>
			<td><%=emloyee.getId()%></td>
			<td><%=emloyee.getName()%></td>
			<td><%=emloyee.getDate()%></td>
			<td><%=emloyee.getEmail()%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>