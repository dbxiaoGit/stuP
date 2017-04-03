<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加学生结果</title>
</head>
<body>
	<%
		StringBuilder content = new StringBuilder();
		try {
			String s = request.getSession().getAttribute("ctype").toString();
			String msg = request.getAttribute("msg").toString();
			if (s.equals("admin")) {
				content.append(msg);
			} else {
				content.append("<a href=\"login.html\">对不起，您没有权限访问该页面！点击这里登录</a>");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(content.toString().equals("")) {
				content.append("<a href=\"login.html\">对不起，您的请求来路不合法或没有权限访问该页面！点击这里登录</a>");
			}
		}
	%>
	<%=content %>
</body>
</html>