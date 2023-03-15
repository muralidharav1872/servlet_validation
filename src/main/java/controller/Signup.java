package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import dao.UserDao;
import dto.UserInfo;

@WebServlet("/signup")
public class Signup extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Date date=Date.valueOf(req.getParameter("dob"));
		
		UserInfo info = new UserInfo();
		info.setAddress(req.getParameter("address"));
		info.setCountry(req.getParameter("country"));
		info.setDate(Date.valueOf(req.getParameter("dob")));
		info.setEmail(req.getParameter("email"));
		info.setGender(req.getParameter("gender"));
		info.setName(req.getParameter("name"));
		info.setPassword(req.getParameter("pwd"));
		info.setPhone(Long.parseLong(req.getParameter("phone")));
		info.setSkills(req.getParameterValues("skills"));
		
		info.setAge(Period.between(date.toLocalDate(), LocalDate.now()).getYears());
		
		
		UserDao dao=new UserDao();
		dao.save(info);
		
		res.getWriter().print("<h1>Account created successfully</h1>");
		req.getRequestDispatcher("login.html").include(req, res);

		// PrintWriter out = res.getWriter();
		// res.getWriter()
		// .print("<h1>" + "<br>Name:" + name + "<br>Phone :" + phone +
		// "<br>Email :" + email + "<br>Password :"
		// + password + "<br>Date :" + date + "<br>Gender :" + gender +
		// "<br>Address :" + address
		// + "<br>Country :" + country + "<br>Skills :" +
		// Arrays.toString(skills) + "</h1>");
	}

}
