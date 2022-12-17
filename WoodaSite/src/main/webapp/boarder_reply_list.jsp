<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%
	request.setCharacterEncoding("utf-8");
	String bs_num = request.getParameter("bs_num");
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost/junni802";	

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	//" from t_member_info where mi_id = '" + uid + "' ";

	String sql = "select b.mi_nick, b.br_content from t_board_story a, t_board_reply b where a.bs_num = b.bs_num and b.bs_num = '" + bs_num + "'";

	try {
		String result = "";
		Class.forName(driver);
		conn = DriverManager.getConnection(url, "junni802", "jun6174aA");
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		if (rs.next()) {
			do {
				result = rs.getString("mi_nick");
				result += " : ";
				result += rs.getString("br_content") + "|";
				result += "\n";
				out.println(result);
			} while (rs.next());
		} else {
			out.print("검색 결과가 없습니다.");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
%>