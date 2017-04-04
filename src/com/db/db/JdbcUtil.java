/**
 * @author dbxiao
 */
package com.db.db;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtil {
	//private static ComboPooledDataSource ds;
	private static DataSource ds;
	static{
		ds = new ComboPooledDataSource("db");
		/*
		ds = new ComboPooledDataSource();
		try {
			ds.setDriverClass( "com.mysql.jdbc.Driver");
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}           
		ds.setJdbcUrl( "jdbc:mysql:///stuP?characterEncoding=utf8&serverTimezone=UTC" );
		ds.setUser("root");                                  
		ds.setPassword("");                                  
			
		ds.setMinPoolSize(5);     
		ds.setInitialPoolSize(10);
		ds.setAcquireIncrement(5);
		ds.setMaxPoolSize(20);
		*/
	}
	
	public DataSource getDatasource() {
		return ds;
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(ResultSet rs,Statement st,Connection co) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				rs = null;
			}
		}
		
		if(st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				st = null;
			}
		}
		
		if(co != null) {
			try {
				co.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				co = null;
			}
		}
	}
}
