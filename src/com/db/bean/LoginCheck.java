package com.db.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.db.db.JdbcUtil;

public class LoginCheck {
	public static boolean check(String username,String password,String ctype) {
		Connection conn = JdbcUtil.getConnection();
		String sql = "select * from user where username = ? and password = ? and utype = ?";
		PreparedStatement st =null;
		ResultSet rs = null;
		boolean result = false;
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, username);
			st.setString(2, password);
			st.setString(3, ctype);
			rs = st.executeQuery();
			result = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs, st, conn);
		}
		
		if(result) {
			return true;
		} else {
			return false;
		}
	}
}
