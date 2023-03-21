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
import r2s.utils.LogFactory;

@WebServlet(urlPatterns = "/ListEmployee")
public class ListEmployeeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LogFactory.getLogger().info("Running on method doGet of Register Servlet");
		request.getRequestDispatcher("views/ListEmployee.jsp").forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Employee> listEmployees = new ArrayList<Employee>();
		ArrayList<Department> listDeparment = new ArrayList<Department>();
		try {
			// call method getAllEmployee to get employee from DB
			EmployeeDao employeeDao = new EmployeeDao();
			listEmployees = employeeDao.getAllEmployee();
			// call method getAllDepartMent to get departments from DB
			DepartmentDao departmentDao = new DepartmentDao();
			listDeparment = departmentDao.getAllDepartMent();
			
			for (Employee employee : listEmployees) {
				for (Department department : listDeparment) {
					if(employee.getDepartmentID().equals(department.getID())) {
						employee.setDepartmentID(department.getName());
					}
				}
			}
			request.setAttribute("listEmployee", listEmployees);
			request.getRequestDispatcher("/views/ListEmployee.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath() + "/ListEmployee");
		} catch (ClassNotFoundException | SQLException e) {
			// log error if exception occurs
			LogFactory.getLogger().error("An exception occurs while get list employee. " + e.getMessage());
		}

	}
}
