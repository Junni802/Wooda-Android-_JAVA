package ctr;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.CoupleSendAcceptSvc;
import svc.CoupleSendRefuseSvc;

@WebServlet("/CoupleAccept")
public class CoupleSendAcceptCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CoupleSendAcceptCtrl() { super(); }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String memail = request.getParameter("memail");
		String uemail = request.getParameter("uemail");
		
		CoupleSendAcceptSvc coupleSendAcceptSvc = new CoupleSendAcceptSvc();
		String num = coupleSendAcceptSvc.sendDelete(memail, uemail);
		
		response.setContentType("text/html; charser=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("{"
				+ "\"num\":\"" + num + "\""
				+ "}");
	}

}
