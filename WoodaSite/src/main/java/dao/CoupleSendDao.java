package dao;

import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;

public class CoupleSendDao {
	private static CoupleSendDao coupleSendDao;
	private Connection conn;

	private CoupleSendDao() {
	}

	public static CoupleSendDao getInstance() {
		if (coupleSendDao == null)
			coupleSendDao = new CoupleSendDao();
		return coupleSendDao;
	}

	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	public int sendCouple(String sEmail, String rEmail, String endDate) {
		int result = 0;
		Statement stmt = null;
		
		try {

			stmt = conn.createStatement();
			String sql = "insert into t_couple_mailing(cm_mail_r, cm_mail_s, cm_endDate) "
						+ "values ('" + rEmail + "', '" + sEmail + "', '" + endDate + "') ";
			result = stmt.executeUpdate(sql);

		} catch (Exception e) {
			System.out.println("CoupleSendDao오류 발샐");
			e.printStackTrace();
		} finally {
			close(stmt);
		}
		
		return result;
	}

}
