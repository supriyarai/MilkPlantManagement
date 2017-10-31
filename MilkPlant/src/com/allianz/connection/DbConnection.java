package com.allianz.connection;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.allianz.servlet.StockServlet;

/**
 * This class is taken for establishing the connection with database
 * @author User
 *
 */
public class DbConnection {
	private static final Logger logger=Logger.getLogger(DbConnection.class);

	/**
	 * Initializing connection with null 
	 */
	private static Connection con =null;
	/**
	 * default constructor
	 */
	private DbConnection() {
		super();
	}//default constructor ends
	/**
	 * method for establishing the connection 
	 * @return Connection type
	 */
	public static Connection getConnection() {
		try {
			if (con != null) 
				if (!con.isClosed()) {
					return con;

				}//if ends
			ClassLoader classLoader = Thread.currentThread()
					.getContextClassLoader();
			InputStream input = classLoader
					.getResourceAsStream("com/allianz/dbProperties/db.properties");
			Properties property = new Properties();
			property.load(input);

			String dbDriver = property.getProperty("db.driver");
			String dbHost = property.getProperty("db.host");
			String dbProtocol = property.getProperty("db.protocol");
			String dbName = property.getProperty("db.dbname");
			String dbPort = property.getProperty("db.port");
			String dbUser = property.getProperty("db.user");
			String dbPassword = property.getProperty("db.password");

			String connectionString = dbProtocol + "://" + dbHost + ":"
					+ dbPort + "/" + dbName;
			/**
			 * registering the driver
			 */
			Class.forName(dbDriver);
			logger.info("registered");
			/**
			 * connection with database
			 */
			con = DriverManager.getConnection(connectionString, dbUser,
					dbPassword);
			logger.info("connection done");
		}//try ends
		catch (Exception e) 
		{
			e.printStackTrace();
			logger.error(e);
		}//catch ends
		return con;
	}//getConnection ends
}//class ends
