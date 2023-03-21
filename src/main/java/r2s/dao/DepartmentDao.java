package r2s.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import r2s.model.Department;
import r2s.utils.DBUtils;

public class DepartmentDao {
	public ArrayList<Department> getAllDepartMent() throws ClassNotFoundException, IOException, SQLException {
		Connection connection = null;
		try {
			connection = DBUtils.getConnection();
			CallableStatement callableStatement = connection.prepareCall("{call usp_findAllDepartment}");

			ResultSet result = callableStatement.executeQuery();

			ArrayList<Department> listDeparment = new ArrayList<Department>();
			while (result.next()) {
				int param = 1;
				Department department = new Department(result.getString(param++), result.getString(param++));
				listDeparment.add(department);
			}

			return listDeparment;
		} finally {
			DBUtils.closeConnection(connection);
			
		}
	}
}
