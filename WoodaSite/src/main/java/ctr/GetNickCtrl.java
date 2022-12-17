package ctr;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.GetNickSvc;


@WebServlet("/NickName")
public class GetNickCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetNickCtrl() { super(); }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String email = request.getParameter("email");
		System.out.println(email);
		
		GetNickSvc getNickSvc = new GetNickSvc();
		String nick = getNickSvc.getNick(email);
		
		response.setContentType("text/html; charser=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("{\"nick\":\"" + nick +  "\"}");
	}

}
