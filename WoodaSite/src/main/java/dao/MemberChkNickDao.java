package dao;

import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;

public class MemberChkNickDao {
	private static MemberChkNickDao memberChkNickDao;
	private Connection conn;

	private MemberChkNickDao() {
	}

	public static MemberChkNickDao getInstance() {
		if (memberChkNickDao == null)
			memberChkNickDao = new MemberChkNickDao();
		return memberChkNickDao;
	}

	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	public String NickChk(String nick) {
		String num = "";
		Statement stmt = null;
		ResultSet rs = null;

		try {

			stmt = conn.createStatement();
			String sql = "select count(*) cnt from t_member_info where mi_nick = '" + nick + "'";
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				num = rs.getString("cnt");
			}

		} catch (Exception e) {
			System.out.println("MemberChkNickDao오류 발샐");
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}

		return num;
	}
}
