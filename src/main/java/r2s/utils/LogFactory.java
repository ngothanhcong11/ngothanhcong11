package r2s.utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Class Log4J utility
 * 
 * @author kyle
 *
 */
public class LogFactory {
	private static final Logger logger = Logger.getLogger(LogFactory.class);

	/**
	 * method configure Log4J.
	 * 
	 * @return Logger logger
	 */
	public static Logger getLogger() {
		PropertyConfigurator.configure(LogFactory.class.getClassLoader().getResourceAsStream(Constants.FILE_NAME_LOG4J));
		return logger;
	}
}
