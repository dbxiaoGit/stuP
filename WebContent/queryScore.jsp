<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.db.db.JdbcUtil,java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,
 java.sql.SQLException"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>queryScore</title>
</head>
<body>
	<%
		StringBuilder content = new StringBuilder();
		try {
			String username = request.getSession().getAttribute("username").toString();
			String ctype = request.getSession().getAttribute("ctype").toString();
			if (ctype.equals("student")) {
				Connection conn = JdbcUtil.getConnection();
				String sql = "select student.sno,sname,cname,grade from score,student,course where score.sno=student.sno and score.cno=course.cno and student.sno = ? ";
				PreparedStatement st =null;
				ResultSet rs = null;
				try {
					st = conn.prepareStatement(sql);
					st.setString(1, username);
					rs = st.executeQuery();
					content.append("<table><tr><td>学号</td><td>姓名</td><td>课程名</td><td>成绩</td></tr>");
					while (rs.next()) {
						content.append("<tr><td>");content.append(rs.getString(1));content.append("</td><td>");
						content.append(rs.getString(2));content.append("</td><td>");content.append(rs.getString(3));
						content.append("</td><td>");content.append(rs.getString(4));content.append("</td></tr>");
					}
					content.append("</table>");
					//System.out.println(sql);
					//System.out.println(content);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					JdbcUtil.close(rs, st, conn);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(content.toString().equals("")) {
				content.append("<a href=\"login.html\">对不起，您没有权限访问该页面！点击这里登录</a>");
			}
		}
	%>
	<div>
		<%=content %>
	</div>
</body>
</html>