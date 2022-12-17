<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%
request.setCharacterEncoding("utf-8");
String id = request.getParameter("mi_id");
String pw = request.getParameter("mi_pw");
String driver = "com.mysql.jdbc.Driver";
String url = "jdbc:mysql://localhost/junni802";	

Connection conn = null;
Statement stmt = null;
ResultSet rs = null;

//" from t_member_info where mi_id = '" + uid + "' ";

String sql = "update t_member_info set mi_pw = '" + pw + "' where mi_mail = '" + id + "'";

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
