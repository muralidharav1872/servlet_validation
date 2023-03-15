<%@page import="java.util.Arrays"%>
<%@page import="dto.UserInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1">


		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Phone</th>
			<th>Email</th>
			<th>Password</th>
			<th>Date</th>
			<th>Gender</th>
			<th>Address</th>
			<th>Country</th>
			<th>Skills</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>

		<%
			List<UserInfo> list = (List<UserInfo>) request.getAttribute("list");
			for (UserInfo user : list) {
		%>
		<tr>
			<th><%=user.getId()%></th>
			<th><%=user.getName()%></th>
			<th><%=user.getPhone()%></th>
			<th><%=user.getEmail()%></th>
			<th><%=user.getPassword()%></th>
			<th><%=user.getDate()%></th>
			<th><%=user.getGender()%></th>
			<th><%=user.getAddress()%></th>
			<th><%=user.getCountry()%></th>
			<th><%=Arrays.toString(user.getSkills())%></th>
			<th><a href="edit.jsp?id=<%=user.getId()%>"><button>Edit</button></a></th>
			<th><a href="delete?id=<%=user.getId()%>"><button>Delete</button></a></th>
		</tr>
		<%
			}
		%>0



	</table>
</body>
</html>