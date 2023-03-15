package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.UserInfo;

@WebServlet("/update")
public class Update extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		UserInfo user=new UserInfo();
		user.setAddress(req.getParameter("address"));
		user.setCountry(req.getParameter("country"));
		user.setDate(Date.valueOf(req.getParameter("dob")));
		user.setEmail(req.getParameter("email"));
		user.setGender(req.getParameter("gender"));
		user.setName(req.getParameter("name"));
		user.setPassword(req.getParameter("pwd"));
		user.setPhone(Long.parseLong(req.getParameter("phone")));
		user.setSkills(req.getParameterValues("skills"));
		user.setId(Integer.parseInt(req.getParameter("id")));
		
		UserDao dao=new UserDao();
		dao.update(user);
		
		req.setAttribute("list", dao.fetchAll());
		res.getWriter().print("<h1>Data updated Successfully</h1>");
		req.getRequestDispatcher("Home.jsp").include(req, res);
	}
}
