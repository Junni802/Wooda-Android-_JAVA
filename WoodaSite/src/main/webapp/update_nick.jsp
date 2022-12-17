<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%
request.setCharacterEncoding("utf-8");
String mi_mail = request.getParameter("mi_mail");
String mi_nick = request.getParameter("mi_nick");
String driver = "com.mysql.jdbc.Driver";
String url = "jdbc:mysql://localhost/junni802";

Connection conn = null;
Statement stmt = null;
ResultSet rs = null;

//" from t_member_info where mi_id = '" + uid + "' ";

String sql = "update t_member_info set mi_nick = '" + mi_nick + "' where mi_mail = '" + mi_mail + "'";

try {
	int result = 0;
	Class.forName(driver);
	conn = DriverManager.getConnection(url, "junni802", "jun6174aA");
	stmt = conn.createStatement();
	result = stmt.executeUpdate(sql);
	out.println(result);
} catch (Exception e) {
	e.printStackTrace();
}
%>