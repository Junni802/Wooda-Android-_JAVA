package dao;

import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;

public class LoginDao {
	
	private static LoginDao loginDao;
	private Connection conn;
	private LoginDao() {}

	public static LoginDao getInstance() {
		if (loginDao == null)	loginDao = new LoginDao();
		return loginDao;
	}

	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	public String loginChk(String uid, String upw) {
		
		String result = "";
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			String sql = "select count(*) from t_member_info where mi_mail = '" + uid + "' and mi_pw = '" + upw + "' ";
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) result = rs.getInt(1) + "";
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);	close(stmt);
		}
	
		return result;
	}

}
