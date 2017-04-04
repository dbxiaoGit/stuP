/**
 * @author dbxiao
 */
package com.db.services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.db.JdbcUtil;
public class addStudent1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		String ctype = null;
		String msg = null;
		Connection conn = null;
		PreparedStatement st =null;
		ResultSet rs = null;
		try {
			ctype = request.getSession().getAttribute("ctype").toString();
			String sno = request.getParameter("sno").toString();
			String sname = request.getParameter("sname").toString();
			String ssex = request.getParameter("ssex").toString();
			String clno = request.getParameter("clno").toString();
			if(ctype.equals("admin")) {
				if(sno.length() == 10 && sname.length() <= 20 && ssex.length() == 1 && clno.length() == 4 ) {
					conn = JdbcUtil.getConnection();
					String sql = "insert into student(sno,sname,ssex,clno) values(?,?,?,?)";
						st = conn.prepareStatement(sql);
						st.setString(1, sno);
						st.setString(2, sname);
						st.setString(3, ssex);
						st.setString(4, clno);
						//System.out.println(sno+sname+ssex+clno);
						//System.out.println(st.toString());
						st.executeUpdate();
						msg = "<a href=\"main.jsp\">sucess!</a>";
				} else {
					msg = "<a href=\"addStudent.jsp\">对不起，您输入的数据不对！点击返回</a>";
				}
			} else {
				msg = "<a href=\"login.html\">对不起，您没有权限访问该页面！点击这里登录</a>";
			}
		} catch(Exception e) {
			e.printStackTrace();
			msg = "<a href=\"addStudent.jsp\">对不起，服务器开了个小差，插入失败了！点击返回</a>";
		} finally {
			JdbcUtil.close(rs, st, conn);
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("addStudentResult.jsp").forward(request, response);
		}
	}

}
