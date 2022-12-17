package ctr;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.CoupleSendSvc;


@WebServlet("/CoupleSend")
public class CoupleSendCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CoupleSendCtrl() { super(); }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String sEmail = request.getParameter("sEmail");
		String rEmail = request.getParameter("rEmail");
		String endDate = request.getParameter("endDate");
	
		CoupleSendSvc coupleSendSvc = new CoupleSendSvc();
		String num = coupleSendSvc.sendCouple(sEmail, rEmail, endDate);
		
		
		response.setContentType("text/html; charser=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("{\"num\":\"" + num +  "\"}");
	}

}
