<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%
	request.setCharacterEncoding("utf-8");
	String schtype = request.getParameter("schtype");
	String keyword = request.getParameter("keyword");
	String where = "";
	if(schtype != null && !schtype.equals("") && keyword != null & !keyword.equals("")){
		where = " where bs_" + schtype + " like '%" + keyword + "%' ";
	}
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost/junni802";	

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	//" from t_member_info where mi_id = '" + uid + "' ";

	String sql = "select bs_title, bs_start, bs_end, bs_content, bs_num, bs_like, bs_img1, bs_img2, bs_img3 from t_board_story " + where;

	try {
		String result = "";
		Class.forName(driver);
		conn = DriverManager.getConnection(url, "junni802", "jun6174aA");
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		if (rs.next()) {
			do {
				result = rs.getString("bs_title") + "|";
				result += rs.getString("bs_start") + "|";
				result += rs.getString("bs_end") + "|";
				result += rs.getString("bs_content") + "|";
				result += rs.getString("bs_num") + "|";
				result += rs.getString("bs_like") + "|";
				result += rs.getString("bs_img1") + "|";
				result += rs.getString("bs_img2") + "|";
				result += rs.getString("bs_img3") + "|";
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