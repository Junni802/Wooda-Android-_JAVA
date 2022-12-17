<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%
request.setCharacterEncoding("utf-8");
String id = request.getParameter("mi_id");
String driver = "com.mysql.jdbc.Driver";
String url = "jdbc:mysql://localhost/junni802";	

Connection conn = null;
Statement stmt = null;
ResultSet rs = null;

//" from t_member_info where mi_id = '" + uid + "' ";

String sql = "select mi_mail, mi_pw, mi_nick  from t_member_info where mi_mail = '" + id + "' ";

try {
	String result = "";
	Class.forName(driver);
	conn = DriverManager.getConnection(url, "junni802", "jun6174aA");
	stmt = conn.createStatement();
	rs = stmt.executeQuery(sql);
	if (rs.next()) {
		result = rs.getString("mi_mail") + "|";
		result += rs.getString("mi_pw") + "|";
		result += rs.getString("mi_nick");
		result += "\n";
		out.println(result);
	} else {
		out.print("검색 결과가 없습니다.");
	}
} catch (Exception e) {
	e.printStackTrace();
}
%>
