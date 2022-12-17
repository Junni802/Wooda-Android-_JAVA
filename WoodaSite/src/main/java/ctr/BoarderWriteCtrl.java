package ctr;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoarderWriteSvc;

@WebServlet("/Write")
public class BoarderWriteCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoarderWriteCtrl() { super(); }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String email = request.getParameter("email");
		String nick = request.getParameter("nick");
		String area = request.getParameter("area");
		String title = request.getParameter("title");
		String sdate = request.getParameter("sdate");
		String edate = request.getParameter("edate");
		String content = request.getParameter("content");
		String lat1 = request.getParameter("lat1");
		String lng1 = request.getParameter("lng1");
		String place1 = request.getParameter("place1");
		String lat2 = request.getParameter("lat2");
		String lng2 = request.getParameter("lng2");
		String place2 = request.getParameter("place2");
		String lat3 = request.getParameter("lat3");
		String lng3 = request.getParameter("lng3");
		String place3 = request.getParameter("place3");
		String img1 = request.getParameter("img1");
		String img2 = request.getParameter("img2");
		String img3 = request.getParameter("img3");
		
		
		BoarderWriteSvc boarderWriteSvc = new BoarderWriteSvc();
		String num = boarderWriteSvc.writeProc(email, nick, area, title, sdate, edate, 
				content, lat1, lng1, place1, lat2, lng2, place2, lat3, lng3, place3, img1, img2, img3);
		
		response.setContentType("text/html; charser=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("{\"num\":\"" + num +  "\"}");
	}

}
