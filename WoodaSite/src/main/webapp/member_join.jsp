<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%
	request.setCharacterEncoding("utf-8");
	String mi_mail = request.getParameter("mi_mail");
	String mi_name = request.getParameter("mi_name");
	String mi_nick = request.getParameter("mi_nick");
	String mi_pw = request.getParameter("mi_pw");
	String mi_birth = request.getParameter("mi_birth");
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost/junni802";	

	Connection conn = null;
	Statement stmt = null;

	//" from t_member_info where mi_id = '" + uid + "' ";

	try {
		int result = 0;
		Class.forName(driver);
		conn = DriverManager.getConnection(url, "junni802", "jun6174aA");
		stmt = conn.createStatement();
		String sql = "insert into t_member_info(mi_mail, mi_name, mi_nick, mi_pw, mi_birth) " +
				" values ('" + mi_mail + "', '" + mi_name + "', '" + mi_nick + "', '" + mi_pw + "',  '" + mi_birth + "' ) ";
		result = stmt.executeUpdate(sql);
		out.println(result);
	} catch (Exception e) {
		e.printStackTrace();
	}
%>