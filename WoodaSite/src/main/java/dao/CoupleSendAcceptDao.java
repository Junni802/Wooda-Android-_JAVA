package dao;

import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;

public class CoupleSendAcceptDao {
	private static CoupleSendAcceptDao coupleSendAcceptDao;
	private Connection conn;

	private CoupleSendAcceptDao() {
	}

	public static CoupleSendAcceptDao getInstance() {
		if (coupleSendAcceptDao == null)
			coupleSendAcceptDao = new CoupleSendAcceptDao();
		return coupleSendAcceptDao;
	}

	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	public int sendDelete(String memail, String uemail) {
		int result = 0;
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
			String sql = "delete from t_couple_mailing where cm_mail_r = '" + memail + "'";
			result = stmt.executeUpdate(sql);
			
			if(result > 0) {
				sql = "insert into t_couple_info(ci_mail_r, ci_mail_s) values ('" + memail + "', '" + uemail + "')";
				result = stmt.executeUpdate(sql);
			}

		} catch (Exception e) {
			System.out.println("CoupleSendRefuseDao오류 발샐");
			e.printStackTrace();
		} finally {
			close(stmt);
		}
		
		return result;
	}
	
	
}
