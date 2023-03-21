package r2s.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * class handle create connection and close it.
 * 
 * @author kyle
 *
 */
public class DBUtils {
	private static String DRIVER, SERVER_NAME, DB_NAME, USER_NAME, PASSWORD;

	/**
	 * method create connection.
	 * 
	 * @return Connection connection
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
		Properties properties = new Properties();

		try (InputStream input = DBUtils.class.getClassLoader().getResourceAsStream(Constants.FILE_NAME_DB_CONFIG)) {

			if (input == null) {
				LogFactory.getLogger().error("Sorry, unable to find config.properties "); // System.out.println("Sorry unable to find config.properties");

				return null;
			}

			// load a properties file from class path, inside static method
			properties.load(input);

			DRIVER = properties.getProperty("driver");
			SERVER_NAME = properties.getProperty("server");
			DB_NAME = properties.getProperty("dbname");
			USER_NAME = properties.getProperty("username");
			PASSWORD = properties.getProperty("password");

			Class.forName(DRIVER);

		} catch (IOException ex) {
			LogFactory.getLogger().error("An exception occurs while get connection " + ex.getMessage());
		}

		return DriverManager.getConnection(SERVER_NAME + DB_NAME + "?allowPublicKeyRetrieval=true&useSSL=false", USER_NAME, PASSWORD);
	}

	/**
	 * method to close connection
	 * 
	 * @param connection Connection
	 * @throws SQLException
	 */
	public static void closeConnection(Connection connection) throws SQLException {
		if (connection != null) {
			connection.close();
		}
	}

}
