<%@page import="java.util.Properties"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.lang.*"%>
<%@ page import="java.util.*"%>
<%@ page import="javax.mail.*"%>
<%@ page import="javax.mail.internet.*"%>
<%@ page import="test1.*"%>

<%
String certificationNum = "";
Random rd = new Random();
int certificationTotal = 6;
char[] characterTable = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
		'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };
for (int i = 0; i < certificationTotal; i++) {
	certificationNum += characterTable[(rd.nextInt(characterTable.length))];
}
%>

<%
if (!certificationNum.equals("")) {
	request.setCharacterEncoding("utf-8");
	String sender = "manggo802@naver.com";
	String receiver = request.getParameter("receiver");
	String title = "인증번호 입니다.";
	String content = certificationNum;

	test t1 = new test();

		out.println(t1.mail(sender, receiver, title, content));
}
%>
