package ctr;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.MemberPwChangeSvc;

/**
 * Servlet implementation class MemberPwChangeCtrl
 */
@WebServlet("/PwChange")
public class MemberPwChangeCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberPwChangeCtrl() { super(); }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		
		MemberPwChangeSvc memberPwChangeSvc = new MemberPwChangeSvc();
		String num = memberPwChangeSvc.changPassword(email, pw);
		
		response.setContentType("text/html; charser=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("{\"num\":\"" + num +  "\"}");
	}

}
