/**
 * @author dbxiao
 */
package com.db.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.bean.LoginCheck;
public class doLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String ctype = request.getParameter("ctype");
		String headMsg = "错误";
		String bodyMsg = null;
				
		if (ctype.equals("admin")) {
			if (LoginCheck.check(username, password, ctype)) {
				headMsg = "登录成功";
				HttpSession s1 = request.getSession();
				s1.setAttribute("username", username);
				s1.setAttribute("ctype", ctype);
				bodyMsg = "<a href=\"main.jsp\">点击跳转</a>";
			} else {
				bodyMsg = "用户名或密码错误<br/><a href=\"login.html\">返回登录</a>";
			}
		} else if (ctype.equals("student")) {
			if (LoginCheck.check(username, password, ctype)) {
				headMsg = "登录成功";
				HttpSession s1 = request.getSession();
				s1.setAttribute("username", username);
				s1.setAttribute("ctype", ctype);
				bodyMsg = "<a href=\"main.jsp\">点击跳转</a>";
			} else {
				bodyMsg = "用户名或密码错误<br/><a href=\"login.html\">返回登录</a>";
			}
		} else if (ctype.equals("teacher")) {
			if (LoginCheck.check(username, password, ctype)) {
				headMsg = "登录成功";
				HttpSession s1 = request.getSession();
				s1.setAttribute("username", username);
				s1.setAttribute("ctype", ctype);
				bodyMsg = "<a href=\"main.jsp\">点击跳转</a>";
			} else {
				bodyMsg = "用户名或密码错误<br/><a href=\"login.html\">返回登录</a>";
			}
		} else {
			bodyMsg = "用户类型错误<br/><a href=\"login.html\">返回登录</a>";
		}
		request.setAttribute("headMsg", headMsg);
		request.setAttribute("bodyMsg", bodyMsg);
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}

}
