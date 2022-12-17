package ctr;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.MemberJoinSvc;


@WebServlet("/Join")
public class MemberJoinCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MemberJoinCtrl() { super(); }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String nick = request.getParameter("nick");
		String pw = request.getParameter("pw");
		String birth = request.getParameter("birth");
		
		MemberJoinSvc memberJoinSvc = new MemberJoinSvc();
		String num = memberJoinSvc.goJoin(email, name, nick, pw, birth);
		
		response.setContentType("text/html; charser=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("{\"num\":\"" + num +  "\"}");
		
	}

}
