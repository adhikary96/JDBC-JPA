package com.cg.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.cg.jdbc.exception.JDBCException;

public class DbUtil {
	
	public static Connection getConnection() throws JDBCException{
		String url = "jdb:oracle:thin:@localhost:1521:XE";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection(url,"system","orcl11g");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new JDBCException(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new JDBCException(e.getMessage());
		}
		
	}

}
