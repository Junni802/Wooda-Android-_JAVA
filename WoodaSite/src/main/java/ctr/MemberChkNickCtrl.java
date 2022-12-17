package ctr;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.MemberChkEmailSvc;
import svc.MemberChkNickSvc;


@WebServlet("/chkNick")
public class MemberChkNickCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MemberChkNickCtrl() { super(); }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String nick = request.getParameter("nick");
		
		MemberChkNickSvc memberChkNickSvc = new MemberChkNickSvc();
		String num = memberChkNickSvc.NickChk(nick);
		
		response.setContentType("text/html; charser=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("{\"num\":\"" + num +  "\"}");
	}

}
