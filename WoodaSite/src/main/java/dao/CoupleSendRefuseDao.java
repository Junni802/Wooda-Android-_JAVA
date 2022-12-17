package dao;

import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;

public class CoupleSendRefuseDao {
	private static CoupleSendRefuseDao coupleSendRefuseDao;
	private Connection conn;

	private CoupleSendRefuseDao() {
	}

	public static CoupleSendRefuseDao getInstance() {
		if (coupleSendRefuseDao == null)
			coupleSendRefuseDao = new CoupleSendRefuseDao();
		return coupleSendRefuseDao;
	}

	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	public int sendDelete(String email) {
		int result = 0;
		Statement stmt = null;
		
		try {

			stmt = conn.createStatement();
			String sql = "delete from t_couple_mailing where cm_mail_r = '" + email + "'";
			result = stmt.executeUpdate(sql);

		} catch (Exception e) {
			System.out.println("CoupleSendRefuseDao오류 발샐");
			e.printStackTrace();
		} finally {
			close(stmt);
		}
		
		return result;
	}
	
	
}
