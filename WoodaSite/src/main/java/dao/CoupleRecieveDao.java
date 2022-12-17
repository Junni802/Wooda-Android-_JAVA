package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import vo.CoupleInfo;

public class CoupleRecieveDao {
	private static CoupleRecieveDao coupleRecieveDao;
	private Connection conn;

	private CoupleRecieveDao() {
	}

	public static CoupleRecieveDao getInstance() {
		if (coupleRecieveDao == null)
			coupleRecieveDao = new CoupleRecieveDao();
		return coupleRecieveDao;
	}

	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	public String checkReciever(String email) {
		String mail = "";
		Statement stmt = null;
		ResultSet rs = null;

		try {

			stmt = conn.createStatement();
			String sql = "select cm_mail_s from t_couple_mailing where cm_mail_r = '" + email + "'";
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				mail = rs.getString("cm_mail_s");
			}

		} catch (Exception e) {
			System.out.println("ExitEmailDao오류 발샐");
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}

		return mail;
	}

}
