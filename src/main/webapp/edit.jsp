<%@page import="dto.UserInfo"%>
<%@page import="dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%int id=Integer.parseInt(request.getParameter("id"));
UserDao dao=new UserDao();
UserInfo user=dao.fetch(id); 
%>

<h1>Personal Information</h1>
	<form action="update" method="post">
		<table>
		<tr>
				<th>Id:</th>
				<td><input type="text" value="<%=user.getId()%>" readonly="readonly" name="id"></td>
			</tr>
			<tr>
				<th>Name:</th>
				<td><input type="text" value="<%=user.getName()%>" name="name"></td>
			</tr>
			<tr>
				<th>Phone:</th>
				<td><input type="tel"value="<%=user.getPhone()%>" name="phone" pattern="[0-9]{10}"></td>
			</tr>
			<tr>
				<th>Email:</th>
				<td><input type="email" value="<%=user.getEmail()%>" name="email" required="required"></td>
			</tr>
			<tr>
				<th>Password:</th>
				<td><input type="password" value="<%=user.getPassword()%>" name="pwd"></td>
			</tr>
			<tr>
				<th>Date of Birth:</th>
				<td><input type="date" value="<%=user.getDate()%>" name="dob"></td>
			</tr>
			<tr>
				<th>Gender:</th>
				<%if(user.getGender().equals("Male")){
					%>
				<td><input type="radio" name="gender" checked="checked" value="male">Male<input
					type="radio" name="gender" value="female">Female</td>
					<% 
					}else{
					%>
					<td><input type="radio" value="Male" name="gender" checked="checked" >Male<input
					type="radio" value="Female" name="gender" >Female</td>
					<%					}
					%>
			</tr>
			<tr>
				<th>Address:</th>
				<td><textarea rows="5" cols="30" name="address"><%=user.getAddress()%></textarea></td>
			</tr>
			<tr>
				<th>Country:</th>
				<td><select name="country">
						<option>Select an option</option>
						<option>India</option>
						<option>UAE</option>
						<option>Nepal</option>
				</select></td>
			</tr>
			<tr>
				<th>Skills:</th>
				
				<td><input type="checkbox" name="skills" value="Team Player">Team
					Player <input type="checkbox" name="skills" value="Quick Learner">Quick
					Learner <input type="checkbox" name="skills" value="Leadership">Leadership
				</td>
			</tr>
			<tr>
				<td><button type="reset">Cancel</button>
					<button>Update</button></td>
			</tr>
			</table>
	</form>
</body>
</html>