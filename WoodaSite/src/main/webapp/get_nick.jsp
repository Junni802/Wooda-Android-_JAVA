<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%
	request.setCharacterEncoding("utf-8");
	String mi_mail = request.getParameter("mi_mail");
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost/junni802";	

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	//" from t_member_info where mi_id = '" + uid + "' ";

	String sql = "select mi_nick from t_member_info where mi_mail = '" + mi_mail + "' ";

	try {
		String result = "";
		Class.forName(driver);
		conn = DriverManager.getConnection(url, "junni802", "jun6174aA");
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		if(rs.next()) result = rs.getString("mi_nick");
		out.println(result);
	} catch (Exception e) {
		e.printStackTrace();
	}
%>