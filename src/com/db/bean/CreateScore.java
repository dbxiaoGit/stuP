/**
 * @author dbxiao
 */
package com.db.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateScore {

	public static void main(String[] args) {
		new CreateScore().start();
	}
	
	public void start(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql:///stup?characterEncoding=utf8&serverTimezone=UTC&user=root&password=");
			String sql = "insert into score values(?,?,?)";
			ps = conn.prepareStatement(sql);
			rs = conn.createStatement().executeQuery("select sno from student order by sno");
			while(rs.next()) {
				String sno = rs.getString(1);
	//System.out.println(sno);
				String cno = "c00";
				for (int i = 1;i <= 4;i++) {
					int grade = (int) (100 * Math.random());
					ps.setString(1, sno);
					ps.setString(2, cno+i);
					ps.setInt(3, grade);
					ps.addBatch();
	//System.out.println(ps);
				}
			}
			long time1 = System.currentTimeMillis();
			ps.executeBatch();
			long time2 = System.currentTimeMillis();
			System.out.println("spend time "+(time2-time1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					rs = null;
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					ps = null;
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					conn = null;
				}
			}
		}
	}

}
