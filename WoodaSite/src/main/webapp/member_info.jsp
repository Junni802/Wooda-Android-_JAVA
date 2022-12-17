<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%
	request.setCharacterEncoding("utf-8");
	String mail = request.getParameter("mail");
	String nick = request.getParameter("nick");
	String area = request.getParameter("area");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String sdate = request.getParameter("sdate");
	String edate = request.getParameter("edate");
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost/junni802";	

	Connection conn = null;
	Statement stmt = null;

	//" from t_member_info where mi_id = '" + uid + "' ";

	String sql = "insert into t_board_story(mi_mail, mi_nick, bs_area, bs_title, bs_start, bs_end, bs_content) " +
				" values ('" + mail + "', '" + nick + "', '" + area + "', '" + title + "', '" + sdate + "', '" + edate + "', '" + content + "')";

	try {
		int result = 0;
		Class.forName(driver);
		conn = DriverManager.getConnection(url, "junni802", "jun6174aA");
		stmt = conn.createStatement();
		result = stmt.executeUpdate(sql);
		result = 0;
		out.println(result);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
%>