package r2s.servlet;


import java.io.IOException;
import java.sql.SQLException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import r2s.dao.UserDao;
import r2s.model.User;
import r2s.utils.LogFactory;


@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID=1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("user_name");
		String password = req.getParameter("password");
		String passwordEncode = Base64.getEncoder().encodeToString(password.getBytes());
		//set user with data
		User user = new User(userName, passwordEncode);
		
		try {
			UserDao userDao = new UserDao();
			if(userDao.loginUser(user)) {
				req.setAttribute("UserName", userName);
				HomePageServlet homePageServlet = new HomePageServlet();
				homePageServlet.doGet(req, resp);
				
			}else {
				req.setAttribute("message", "Your acount is not corect!");
				req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			LogFactory.getLogger().error("An exception occurs while get list employee. " + e.getMessage());
		}
		
		
	}
}
