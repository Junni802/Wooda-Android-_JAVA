package dao;

import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;

public class MemberPwChangeDao {
	private static MemberPwChangeDao memberPwChangeDao;
	private Connection conn;

	private MemberPwChangeDao() {
	}

	public static MemberPwChangeDao getInstance() {
		if (memberPwChangeDao == null)
			memberPwChangeDao = new MemberPwChangeDao();
		return memberPwChangeDao;
	}

	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	public int changPassword(String email, String pw) {
		int result = 0;
		Statement stmt = null;
		
		try {

			stmt = conn.createStatement();
			String sql = "update t_member_info set mi_pw = '" + pw + "' where mi_mail = '" + email + "' ";
			result = stmt.executeUpdate(sql);

		} catch (Exception e) {
			System.out.println("MemberPwChangeDao오류 발샐");
			e.printStackTrace();
		} finally {
			close(stmt);
		}
		
		return result;
	}
	
	
}
