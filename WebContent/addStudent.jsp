<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>addStudent</title>
</head>
<body>
	<%
		StringBuilder content = new StringBuilder();
		String username = null;
		String ctype = null;
		try {
			username = request.getSession().getAttribute("username").toString();
			ctype = request.getSession().getAttribute("ctype").toString();
			if(ctype.equals("admin")) {
				content.append("<form action=\"addStudent1\" method=\"post\">学生学号<input type=\"text\" name=\"sno\" /><br/>");
				content.append("学生姓名<input type=\"text\" name=\"sname\" /><br/>");
				content.append("学生性别<input type=\"text\" name=\"ssex\" /><br/>");
				content.append("所在班级<input type=\"text\" name=\"clno\" /><br/>");
				content.append("<input type=\"submit\" value=\"添加\" /><br/>");
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