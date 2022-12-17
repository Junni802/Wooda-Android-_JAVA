package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ExitEmailDao {
	private static ExitEmailDao exitEmailDao;
	private Connection conn;

	private ExitEmailDao() {
	}

	public static ExitEmailDao getInstance() {
		if (exitEmailDao == null)
			exitEmailDao = new ExitEmailDao();
		return exitEmailDao;
	}

	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	public String geExitEmail(String email) {
		String num = "";
		Statement stmt = null;
		ResultSet rs = null;

		try {

			stmt = conn.createStatement();
			String sql = "select count(*) cnt from t_member_info where mi_mail = '" + email + "'";
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				num = rs.getString("cnt");
			}

		} catch (Exception e) {
			System.out.println("ExitEmailDao오류 발샐");
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}

		return num;
	}
}
