<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%
	request.setCharacterEncoding("utf-8");
	String bs_num = request.getParameter("bs_num");
	String email = request.getParameter("email");
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost/junni802";	

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	//" from t_member_info where mi_id = '" + uid + "' ";

	String sql = "update t_board_story set bs_like = bs_like + 1 where bs_num = '" + bs_num + "'";

	try {
		int idx = 0;
		String result = "";
		Class.forName(driver);
		conn = DriverManager.getConnection(url, "junni802", "jun6174aA");
		stmt = conn.createStatement();
		idx = stmt.executeUpdate(sql);
		if(idx > 0){
			sql = "insert into t_board_like (bs_num, mi_mail, bl_like) values('" + bs_num + "', '" + email + "', '1')";
			idx = stmt.executeUpdate(sql);
		}
		if(idx > 0){
			sql = "select bs_like from t_board_story where bs_num = '" + bs_num + "' ";
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				result = rs.getString("bs_like");
				out.println(result);
			}else {
				out.print("검색 결과가 없습니다.");
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
%>