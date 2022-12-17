package ctr;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.MemberInfoSvc;
import vo.*;

@WebServlet("/MemberInfo")
public class MemberInfoCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MemberInfoCtrl() { super(); }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		MemberInfo memberInfo = new MemberInfo();
		String email = request.getParameter("email");
		
		MemberInfoSvc memberInfoSvc = new MemberInfoSvc();
		memberInfo = memberInfoSvc.getInfo(email);
		
		response.setContentType("text/html; charser=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("{"
				+ "\"mi_mail\":\"" + memberInfo.getMi_mail() + "\","
				+ "\"mi_pw\":\"" + memberInfo.getMi_pw() + "\","
				+ "\"mi_nick\":\"" + memberInfo.getMi_nick() + "\""
				+ "}");
		
	} 
}
