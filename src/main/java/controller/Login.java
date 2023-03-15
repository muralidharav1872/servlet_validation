package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.UserInfo;

@WebServlet("/login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String emph = req.getParameter("emph");
		String password = req.getParameter("pwd");

		UserDao dao = new UserDao();
		
		
		List<UserInfo> list=dao.fetchAll();
		
		try {
			long phone = Long.parseLong(emph);
			UserInfo info = dao.fetch(phone);
			if (info == null) {
				res.getWriter().print("<h1> Invalid mobile number <h1>");
				req.getRequestDispatcher("login.html").include(req, res);
			} else if (info.getPassword().equals(password)) {
				res.getWriter().print("<h1> login success<h1>");
				req.setAttribute("list", list);
				req.getRequestDispatcher("Home.jsp").include(req, res);
				
				
//				res.getWriter().print("<table border='1'>");
//				
//				res.getWriter().print("<tr>");
//				res.getWriter().print("<th>Id</th>");
//				res.getWriter().print("<th>Name</th>");
//				res.getWriter().print("<th>phone</th>");
//				res.getWriter().print("<th>email</th>");
//				res.getWriter().print("<th>password</th>");
//				res.getWriter().print("<th>date</th>");
//				res.getWriter().print("<th>gender</th>");
//				res.getWriter().print("<th>address</th>");
//				res.getWriter().print("<th>country</th>");
//				res.getWriter().print("<th>skills</th>");
//				res.getWriter().print("</tr>");
//				
//				for (UserInfo user2:list) {
//					res.getWriter().print("<tr>");
//					res.getWriter().print("<td>"+user2.getId()+"</td>");
//					res.getWriter().print("<td>"+user2.getName()+"</td>");
//					res.getWriter().print("<td>"+user2.getPhone()+"</td>");
//					res.getWriter().print("<td>"+user2.getEmail()+"</td>");
//					res.getWriter().print("<td>"+user2.getPassword()+"</td>");
//					res.getWriter().print("<td>"+user2.getDate()+"</td>");
//					res.getWriter().print("<td>"+user2.getGender()+"</td>");
//					res.getWriter().print("<td>"+user2.getAddress()+"</td>");
//					res.getWriter().print("<td>"+user2.getCountry()+"</td>");
//					res.getWriter().print("<td>"+(Arrays.toString(user2.getSkills()))+"</td>");
//					res.getWriter().print("</tr>");
//				}
//				
//				res.getWriter().print("</table>");
				
				
				
			} else {
				res.getWriter().print("<h1>invalid password<h1>");
				req.getRequestDispatcher("login.html").include(req, res);
			}
		}

		catch (NumberFormatException e) {
			String email = emph;
			UserInfo info = dao.fetch(email);
			if (info == null) {
				res.getWriter().print("<h1> Invalid email  <h1>");
				req.getRequestDispatcher("login.html").include(req, res);
			} else if (info.getPassword().equals(password)) {
				res.getWriter().print("<h1> Login success<h1>");
				req.setAttribute("list", list);
				req.getRequestDispatcher("Home.jsp").include(req, res);
				
				
//				res.getWriter().print("<table border='1'>");
//				
//				res.getWriter().print("<tr>");
//				res.getWriter().print("<th>Id</th>");
//				res.getWriter().print("<th>Name</th>");
//				res.getWriter().print("<th>phone</th>");
//				res.getWriter().print("<th>email</th>");
//				res.getWriter().print("<th>password</th>");
//				res.getWriter().print("<th>date</th>");
//				res.getWriter().print("<th>gender</th>");
//				res.getWriter().print("<th>address</th>");
//				res.getWriter().print("<th>country</th>");
//				res.getWriter().print("<th>skills</th>");
//				res.getWriter().print("</tr>");
//				
//				for (UserInfo user2:list) {
//					res.getWriter().print("<tr>");
//					res.getWriter().print("<td>"+user2.getId()+"</td>");
//					res.getWriter().print("<td>"+user2.getName()+"</td>");
//					res.getWriter().print("<td>"+user2.getPhone()+"</td>");
//					res.getWriter().print("<td>"+user2.getEmail()+"</td>");
//					res.getWriter().print("<td>"+user2.getPassword()+"</td>");
//					res.getWriter().print("<td>"+user2.getDate()+"</td>");
//					res.getWriter().print("<td>"+user2.getGender()+"</td>");
//					res.getWriter().print("<td>"+user2.getAddress()+"</td>");
//					res.getWriter().print("<td>"+user2.getCountry()+"</td>");
//					res.getWriter().print("<td>"+(Arrays.toString(user2.getSkills()))+"</td>");
//					res.getWriter().print("</tr>");
//				}
//				
//				res.getWriter().print("</table>");

				
				
			} else {
				res.getWriter().print("<h1>Invalid password<h1>");
				req.getRequestDispatcher("login.html").include(req, res);
			}

		}
	}
}
