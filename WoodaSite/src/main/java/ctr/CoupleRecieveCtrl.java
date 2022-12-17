package ctr;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.CoupleRecieveSvc;
import svc.ExitEmailSvc;
import svc.MemberChkEmailSvc;
import svc.MemberChkNickSvc;
import vo.CoupleInfo;

@WebServlet("/CoupleRecieve")
public class CoupleRecieveCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CoupleRecieveCtrl() { super(); }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String email = request.getParameter("email");
		String mail = "";
		
		
		CoupleRecieveSvc coupleRecieveSvc = new CoupleRecieveSvc();
		mail = coupleRecieveSvc.checkReciever(email);
		
		
		response.setContentType("text/html; charser=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("{\"cm_mail_s\":\"" + mail +  "\"}");
	}

}
