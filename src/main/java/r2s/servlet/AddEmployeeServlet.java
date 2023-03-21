package r2s.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import r2s.dao.DepartmentDao;
import r2s.dao.EmployeeDao;
import r2s.model.Department;
import r2s.model.Employee;
import r2s.utils.Constants;
import r2s.utils.LogFactory;

@WebServlet(urlPatterns = "/AddEmployee")
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get data from the request using request.getParameter()
		String fullName = request.getParameter("full_name");
		String gender = request.getParameter("gender");
		String DOB = request.getParameter("DOB");
		String department = request.getParameter("department");
		
		// Set data for the employee
		Employee employee = new Employee(fullName, gender, DOB, department);
		AddEmployeeServlet addEmployeeServlet = new AddEmployeeServlet();
		
		try {
			EmployeeDao employeeDao = new EmployeeDao();
			
			// call method AddEmployee to insert employee into DB
			if (employeeDao.AddEmployee(employee)) {
				request.setAttribute("messageSuccess", Constants.EDIT_EMPLOYEE_SUCCESSFULLY_MESSAGE);
				addEmployeeServlet.doGet(request, response);
			} else {
				// send a attribute name as "message" to AddEmployee.jsp page
				request.setAttribute("messageFail", Constants.EDIT_EMPLOYEE_FAIL_MESSAGE);
				addEmployeeServlet.doGet(request, response);
			}

		} catch (ClassNotFoundException | SQLException e) {
			// log error if exception occurs
			LogFactory.getLogger().error("An exception occurs while add employee. " + e.getMessage());
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Department> listDepartment = new ArrayList<Department>();
		try {
			//get list department
			DepartmentDao departmentDao = new DepartmentDao();
			listDepartment = departmentDao.getAllDepartMent();
			// send a attribute name as "alert" to AddEmployee.jsp page to show message
			if (request.getAttribute("messageSuccess") != null) {
				request.removeAttribute("alert");
				request.setAttribute("alert", Constants.ADD_EMPLOYEE_SUCCESSFULLY_MESSAGE);
			} else if (request.getAttribute("messageFail") != null) {
				request.removeAttribute("alert");
				request.setAttribute("alert", Constants.ADD_EMPLOYEE_FAIL_MESSAGE);
			}
			// send a attribute name as "listDepartment" to AddEmployee.jsp page
			request.setAttribute("listDepartment", listDepartment);
			request.getRequestDispatcher("/views/AddEmployee.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// log error if exception occurs
			LogFactory.getLogger().error("An exception occurs while add employee. " + e.getMessage());
		}
	}
}
