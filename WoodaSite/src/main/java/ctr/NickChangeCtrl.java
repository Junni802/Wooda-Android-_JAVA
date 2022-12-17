package ctr;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.NickChangeSvc;


@WebServlet("/NickChange")
public class NickChangeCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public NickChangeCtrl() { super(); }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String email = request.getParameter("email");
		String nick = request.getParameter("nick");
		String num = "";
		
		NickChangeSvc nickChangeSvc = new NickChangeSvc();
		num = nickChangeSvc.changeNick(email, nick);
		
		response.setContentType("text/html; charser=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("{\"num\":\"" + num +  "\"}");
	}

}
