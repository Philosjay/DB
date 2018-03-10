package utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JdbcUtils {
	private static Properties props = null;
	
	static {

		try {
			InputStream in = JdbcUtils.class.getClassLoader()
					.getResourceAsStream("dbconfig.properties");
			props = new Properties();
			props.load(in);
			System.out.println(props);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e1);
		}
			
		try {
			String className = props.getProperty("driverClassName");
	//		String className = "com.mysql.jdbc.Driver";
			System.out.println(className);
			Class.forName(className);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static Connection getConnection() throws Exception{
		
		return DriverManager.getConnection(props.getProperty("url"), 
				props.getProperty("username"),
				props.getProperty("password"));
	}
}

