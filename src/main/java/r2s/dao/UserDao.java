package r2s.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import r2s.model.User;
import r2s.utils.DBUtils;

/**
 * The class contains methods to update and retrieve data from database
 * 
 * @author kyle
 *
 */
public class UserDao {

	/**
	 * The method to insert a new user into database.
	 * 
	 * @param user an user object.
	 * @return true if register successfully.
	 * @throws SQLException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public boolean registerUser(User user) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = null;
		try {
			connection = DBUtils.getConnection();
			CallableStatement callableStatement = connection.prepareCall("{call usp_registerUser(?,?,?,?,?)}");

			int param = 0;

			callableStatement.setString(++param, user.getFirstName());
			callableStatement.setString(++param, user.getLastName());
			callableStatement.setString(++param, user.getEmail());
			callableStatement.setString(++param, user.getUserName());
			callableStatement.setString(++param, user.getPassword());

			int result = callableStatement.executeUpdate();

			if (result > 0) {
				return true;
			}

			return false;

		} finally {
			DBUtils.closeConnection(connection);
		}
	}
	public boolean findUserByUserName(String userName) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = null;
		try {
			connection = DBUtils.getConnection();
			CallableStatement callableStatement = connection.prepareCall("{call usp_getUserByUserName(?)}");

			int param = 0;

			callableStatement.setString(++param, userName);

			int result = callableStatement.executeUpdate();
			if (result > 0) {
				return true;
			}

			return false;

		} finally {
			DBUtils.closeConnection(connection);
		}
	}
	public boolean loginUser(User user) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = null;
		try {
			connection = DBUtils.getConnection();
			CallableStatement callableStatement = connection.prepareCall("{call usp_login(?,?)}");

			int param = 0;
			callableStatement.setString(++param, user.getUserName());
			callableStatement.setString(++param, user.getPassword());
			System.out.println(user.getUserName() + user.getPassword());

			ResultSet result = callableStatement.executeQuery();
			if (result.next()) {
				return true;
			}
			return false;

		} finally {
			DBUtils.closeConnection(connection);
		}
	}
}
