package ctr;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.el.TypeConverter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.tomcat.util.buf.B2CConverter;

import com.mysql.cj.xdevapi.Result;
import com.mysql.cj.xdevapi.Warning;

import svc.LoginSvc;


@WebServlet("/Login")
public class LoginCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginCtrl() { super(); }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		
		LoginSvc loginSvc = new LoginSvc();
		String chk = loginSvc.loginChk(uid, upw);
		
		System.out.println(uid);
		
		response.setContentType("text/html; charser=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("{\"chk\":\"" + chk +  "\"}");
		
	}
	

}
