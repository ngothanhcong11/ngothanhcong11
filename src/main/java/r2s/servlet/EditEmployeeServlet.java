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


@WebServlet(urlPatterns = "/EditEmployee")
public class EditEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get data from the request using request.getParameter()
		String ID = request.getParameter("employeeID");
		String fullName = request.getParameter("full_name");
		String gender = request.getParameter("gender");
		String DOB = request.getParameter("DOB");
		String department = request.getParameter("department");
		// Set data for the employee
		Employee employee = new Employee(ID, fullName, gender, DOB, department);
		EmployeeDao employeeDao = new EmployeeDao();
		ListEmployeeServlet listEmployeeServlet = new ListEmployeeServlet();
		try {
			// call method EditEmployee to edit employee into DB
			if(employeeDao.EditEmployee(employee)) {
				// send a attribute name as "messageSuccess" to ListEmployeeServlet and call method do get
				request.setAttribute("messageSuccess", Constants.ADD_EMPLOYEE_SUCCESSFULLY_MESSAGE);
				listEmployeeServlet.doGet(request, response);
			}else {
				request.setAttribute("messageFail", Constants.ADD_EMPLOYEE_FAIL_MESSAGE);
				listEmployeeServlet.doGet(request, response);
			}
		} catch (Exception e) {
			LogFactory.getLogger().error("An exception occurs while edit employee. " + e.getMessage());
		}
		
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	String id = request.getParameter("sid");
	ListEmployeeServlet listEmployeeServlet = new ListEmployeeServlet();
	ArrayList<Department> listDepartment = new ArrayList<Department>();
	System.out.println(id);
	try {
		DepartmentDao departmentDao = new DepartmentDao();
		// call method getAllDepartMent to get departments from DB
		listDepartment = departmentDao.getAllDepartMent();
		// send a attribute name as "message" to listEmployeeServlet and call method do get
		request.setAttribute("listDepartment", listDepartment);
		
		EmployeeDao employeeDao = new EmployeeDao();
		Employee employee = employeeDao.GetEmployeeByID(id);
		if(employee!=null) {
			
			request.setAttribute("messageDeleteSuccess", Constants.REGISTER_SUCCESSFULLY_MESSAGE);
			request.setAttribute("employeeEdit", employee);
			listEmployeeServlet.doGet(request, response);
		} else {
			// send a attribute name as "message" to listEmployeeServlet and call method do get
			request.setAttribute("message", Constants.REGISTER_FAIL_MESSAGE);
			listEmployeeServlet.doGet(request, response);
		}

	} catch (ClassNotFoundException | SQLException e) {
		LogFactory.getLogger().error("An exception occurs while Edit employee. " + e.getMessage());
	}
	}
}