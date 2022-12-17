package ctr;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.CoupleSendRefuseSvc;

@WebServlet("/CoupleRefuse")
public class CoupleSendRefuseCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CoupleSendRefuseCtrl() { super(); }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String email = request.getParameter("email");
		
		CoupleSendRefuseSvc coupleSendRefuseSvc = new CoupleSendRefuseSvc();
		String num = coupleSendRefuseSvc.sendDelete(email);
		
		response.setContentType("text/html; charser=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("{"
				+ "\"num\":\"" + num + "\""
				+ "}");
	}

}
