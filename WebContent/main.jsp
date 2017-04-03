<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人主页</title>
</head>
<body>
	<%	
		String username = null;
		String role = null;
		String func = null;
		try{
			username = request.getSession().getAttribute("username").toString()+"的工作室";
			role = request.getSession().getAttribute("ctype").toString();
			if (role.equals("admin")) {
				func = "<a href=\"addStudent.jsp\">添加学生</a>";
			} else if (role.equals("student")) {
				func = "<a href=\"queryScore.jsp\">查看成绩</a>";
			} else if (role.equals("teacher")) {
				func = "<a href=\"queryStudent.jsp\">教师信息</a>";
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		if(role == null) {
			username = "对不起";
			func = "<a href=\"login.html\">请先登录</a>";
		}
	%>
	<div>
		<%=username %>
	</div>
	<hr/>
	<div>
		<%=func %>
	</div>
</body>
</html>