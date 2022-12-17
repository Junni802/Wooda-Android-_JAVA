package dao;

import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;

public class MemberChkEmailDao {
	private static MemberChkEmailDao memberChkEmailDao;
	private Connection conn;

	private MemberChkEmailDao() {
	}

	public static MemberChkEmailDao getInstance() {
		if (memberChkEmailDao == null)
			memberChkEmailDao = new MemberChkEmailDao();
		return memberChkEmailDao;
	}

	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	public String emailChk(String email) {
		String num = "";
		Statement stmt = null;
		ResultSet rs = null;
		
		try {

			stmt = conn.createStatement();
			String sql = "select count(*) cnt from t_member_info where mi_mail = '" + email + "'";
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				num = rs.getString("cnt");
			}

		} catch (Exception e) {
			System.out.println("MemberPwChangeDao오류 발샐");
			e.printStackTrace();
		} finally {
			close(rs);		close(stmt);
		}
		
		return num;
	}
	
	
}
