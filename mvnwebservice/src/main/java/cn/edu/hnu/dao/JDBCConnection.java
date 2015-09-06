package cn.edu.hnu.dao;

/**
 * @author ZQL
 * Class:JDBCConnection
 * Usage: connection to the database
 * **/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/mavenwebdemo";
	private static final String USER = "root";
	private static final String PASSWORD = "sa";
	
	public static Connection conn;
	
	//create the connection to database while return only one connection.
	public static synchronized Connection getConnection(){
		System.out.println("...............in the function of getConnection.........");
		if(conn != null){
			return conn;
		}
		try{
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
			if(!conn.isClosed()){
				System.out.println("succeeded connecting to the database!");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return conn;
	}
	
	//close the connection to mysql
	public static void closeConnectionToMysql(){
		try {
			conn.close();
			conn = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
