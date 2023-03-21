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
import r2s.utils.Constants;
import r2s.utils.LogFactory;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get data from the request using request.getParameter()
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String passwordEncode = Base64.getEncoder().encodeToString(password.getBytes());
		// Set data for the user
		User user = new User(firstName, lastName, email, userName, passwordEncode);
		try {
			UserDao userDao = new UserDao();
			if(!userDao.findUserByUserName(userName)) {
				// call method registerUser to insert user into DB
				if (userDao.registerUser(user)) {
					// send a attribute name as "userRegister" to register-user-process.jsp page
					request.setAttribute("userRegister", user);
					// send a attribute name as "message" to register-user.jsp page
					request.setAttribute("message", Constants.REGISTER_SUCCESSFULLY_MESSAGE);
					request.getRequestDispatcher("/views/register-user.jsp").forward(request, response);
				} else {
					// send a attribute name as "message" to register-user.jsp page
					request.setAttribute("message", Constants.REGISTER_FAIL_MESSAGE);
					// forward to register-user.jsp page
					request.getRequestDispatcher("/views/register-user.jsp").forward(request, response);
				}
			}else {
				request.setAttribute("message", Constants.REGISTER_EXIST_USERNAME_MESSAGE);
				request.getRequestDispatcher("/views/register-user.jsp").forward(request, response);
			}

		} catch (ClassNotFoundException | SQLException e) {
			// log error if exception occurs
			LogFactory.getLogger().error("An exception occurs while register user. " + e.getMessage());
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LogFactory.getLogger().info("Running on method doGet of Register Servlet");
		request.getRequestDispatcher("views/register-user.jsp").forward(request, response);
	}

}
