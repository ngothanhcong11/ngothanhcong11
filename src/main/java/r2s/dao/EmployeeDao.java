package r2s.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import r2s.model.Employee;
import r2s.utils.DBUtils;

public class EmployeeDao {
	public ArrayList<Employee> getAllEmployee() throws ClassNotFoundException, IOException, SQLException {
		Connection connection = null;
		try {
			connection = DBUtils.getConnection();
			CallableStatement callableStatement = connection.prepareCall("{call usp_findAllEmployee}");

			ResultSet result = callableStatement.executeQuery();

			ArrayList<Employee> listEmployees = new ArrayList<Employee>();
			while (result.next()) {
				int param = 1;
				Employee employee = new Employee(result.getString(param++), result.getString(param++),
						result.getString(param++), result.getString(param++), result.getString(param++));
				listEmployees.add(employee);
			}

			return listEmployees;
		} finally {
			DBUtils.closeConnection(connection);
		}
	}

	public Boolean AddEmployee(Employee employee) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = null;
		try {
			connection = DBUtils.getConnection();
			CallableStatement callableStatement = connection.prepareCall("{call usp_addEmployee(?,?,?,?)}");

			int param = 0;

			callableStatement.setString(++param, employee.getName());
			callableStatement.setString(++param, employee.getGender());
			callableStatement.setString(++param, employee.getDate());
			callableStatement.setString(++param, employee.getDepartmentID());

			int result = callableStatement.executeUpdate();

			if (result > 0) {
				return true;
			}

			return false;

		} finally {
			DBUtils.closeConnection(connection);
		}
	}

	public Boolean DeleteEmployee(String id) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = null;
		try {
			connection = DBUtils.getConnection();
			CallableStatement callableStatement = connection.prepareCall("call usp_deleteEmployee(?)");

			int param = 0;
			callableStatement.setString(++param, id);
			int result = callableStatement.executeUpdate();

			if (result > 0) {
				return true;
			}

			return false;
		} finally {
			DBUtils.closeConnection(connection);
		}
	}
	public Employee GetEmployeeByID(String id) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = null;
		try {
			connection = DBUtils.getConnection();
			CallableStatement callableStatement = connection.prepareCall("call usp_findEmployeeByID(?)");

			int param = 0;
			callableStatement.setString(++param, id);

			ResultSet result = callableStatement.executeQuery();
			Employee employee = null;
			if (result.next()) {
				employee = new Employee(result.getString(param++), result.getString(param++),
						result.getString(param++), result.getString(param++), result.getString(param++));
			}
			return employee;
			
		} finally {
			DBUtils.closeConnection(connection);
		}
	}
	
	public Boolean EditEmployee(Employee employee) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = null;
		try {
			connection = DBUtils.getConnection();
			CallableStatement callableStatement = connection.prepareCall("{call usp_editEmployee(?,?,?,?,?)}");

			int param = 0;
			callableStatement.setString(++param, employee.getEmployeeID());
			callableStatement.setString(++param, employee.getName());
			callableStatement.setString(++param, employee.getGender());
			callableStatement.setString(++param, employee.getDate());
			callableStatement.setString(++param, employee.getDepartmentID());

			int result = callableStatement.executeUpdate();

			if (result > 0) {
				return true;
			}

			return false;

		} finally {
			DBUtils.closeConnection(connection);
		}
	}
}
