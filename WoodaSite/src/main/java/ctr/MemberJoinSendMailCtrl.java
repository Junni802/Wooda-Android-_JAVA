package ctr;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import test1.*;

@WebServlet("/Mail")
public class MemberJoinSendMailCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberJoinSendMailCtrl() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String receiver = request.getParameter("receiver");

		String certificationNum = "";
		Random rd = new Random();
		int certificationTotal = 6;
		char[] characterTable = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
				'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };
		for (int i = 0; i < certificationTotal; i++) {
			certificationNum += characterTable[(rd.nextInt(characterTable.length))];
		}

		if (!certificationNum.equals("")) {
			request.setCharacterEncoding("utf-8");
			String sender = "manggo802@naver.com";
			String title = "인증번호 입니다.";
			String content = certificationNum;

			test t1 = new test();

			response.setContentType("text/html; charser=utf-8");
			PrintWriter out = response.getWriter();

			out.println("{\"num\":\"" + t1.mail(sender, receiver, title, content) + "\"}");

		}

	}
}
