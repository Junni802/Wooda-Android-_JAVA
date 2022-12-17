package dao;

import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;

public class MemberJoinDao {
	private static MemberJoinDao memberJoinDao;
	private Connection conn;

	private MemberJoinDao() {
	}

	public static MemberJoinDao getInstance() {
		if (memberJoinDao == null)
			memberJoinDao = new MemberJoinDao();
		return memberJoinDao;
	}

	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	public int goJoin(String email, String name, String nick, String pw, String birth) {
		int result = 0;
		Statement stmt = null;
		
		try {

			stmt = conn.createStatement();
			String sql = "insert into t_member_info(mi_mail, mi_name, mi_nick, mi_pw, mi_birth) "
					+ " values ('" + email + "', '" + name + "', '" + nick + "', '" + pw + "', '" + birth + "') ";
			result = stmt.executeUpdate(sql);

		} catch (Exception e) {
			System.out.println("MemberJoinDao오류 발샐");
			e.printStackTrace();
		} finally {
			close(stmt);
		}
		
		return result;
	}
}
