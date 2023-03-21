package r2s.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import r2s.dao.EmployeeDao;
import r2s.utils.Constants;
import r2s.utils.LogFactory;


@WebServlet(urlPatterns = "/DeleteEmployee")
public class DeleteEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/ListEmployee.jsp").forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	String id = request.getParameter("sid");
	ListEmployeeServlet listEmployeeServlet = new ListEmployeeServlet();
	try {
		EmployeeDao employeeDao = new EmployeeDao();
		if(employeeDao.DeleteEmployee(id)) {
			request.setAttribute("messageDeleteSuccess", Constants.REGISTER_SUCCESSFULLY_MESSAGE);
			listEmployeeServlet.doGet(request, response);
		} else {
			// send a attribute name as "message" to register-user.jsp page
			request.setAttribute("message", Constants.REGISTER_FAIL_MESSAGE);
			// forward to register-user.jsp page
			listEmployeeServlet.doGet(request, response);
		}

	} catch (ClassNotFoundException | SQLException e) {
		LogFactory.getLogger().error("An exception occurs while delete employee. " + e.getMessage());
	}
	}
}
