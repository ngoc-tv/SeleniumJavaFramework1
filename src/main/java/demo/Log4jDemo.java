package demo;

import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;

public class Log4jDemo {

	private static Logger logger = LogManager.getLogger(Log4jDemo.class);
	
	public static void main(String[] args) {
		
		BasicConfigurator.configure();
	
		System.out.println("\n Hello World..	\n");
		logger.trace("trace message");
		logger.info("Information message");
		logger.error("this is an error message");
		logger.warn("this is an warnning message");
		logger.fatal("this is a fata message");
		
		System.out.println("\n Completed");

	}

}
