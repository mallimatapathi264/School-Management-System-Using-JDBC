package com.School;

import java.sql.*;
import java.sql.DriverManager;

public class Helper {

	public static Connection getConnectionobj() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolmangamentsystem","root","root");
		return con;
	}
}