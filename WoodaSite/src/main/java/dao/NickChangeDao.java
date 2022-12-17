package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.Statement;

public class NickChangeDao {
	private static NickChangeDao nickChangeDao;
	private Connection conn;

	private NickChangeDao() {
	}

	public static NickChangeDao getInstance() {
		if (nickChangeDao == null)
			nickChangeDao = new NickChangeDao();
		return nickChangeDao;
	}

	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	public int changPassword(String email, String nick) {
		int result = 0;
		Statement stmt = null;
		
		try {

			stmt = conn.createStatement();
			String sql = "update t_member_info set mi_nick = '" + nick + "' where mi_mail = '" + email + "' ";
			result = stmt.executeUpdate(sql);

		} catch (Exception e) {
			System.out.println("NickChangeDao오류 발샐");
			e.printStackTrace();
		} finally {
			close(stmt);
		}
		
		return result;
	}
	
	
}
