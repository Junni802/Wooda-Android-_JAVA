package dao;

import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;

public class GetNickDao {
	private static GetNickDao getNickDao;
	private Connection conn;

	private GetNickDao() {
	}

	public static GetNickDao getInstance() {
		if (getNickDao == null)
			getNickDao = new GetNickDao();
		return getNickDao;
	}

	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	public String getNick(String email) {

		String result = "";
		Statement stmt = null;
		ResultSet rs = null;

		try {

			stmt = conn.createStatement();
			String sql = "select mi_nick from t_member_info where mi_mail = '" + email + "' ";
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				result = rs.getString("mi_nick");

			}

		} catch (Exception e) {
			System.out.println("GetNickDao오류 발샐");
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}

		return result;
	}

}
