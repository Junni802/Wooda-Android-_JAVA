package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import vo.MemberInfo;

public class MemberInfoDao {
	private static MemberInfoDao memberInfoDao;
	private Connection conn;

	private MemberInfoDao() {
	}

	public static MemberInfoDao getInstance() {
		if (memberInfoDao == null)
			memberInfoDao = new MemberInfoDao();
		return memberInfoDao;
	}

	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	

	public MemberInfo getInfo(String email) {
		MemberInfo memberInfo = new MemberInfo();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {

			stmt = conn.createStatement();
			String sql = "select mi_mail, mi_pw, mi_nick, mi_name from t_member_info where mi_mail = '" + email + "' ";
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				memberInfo.setMi_mail(rs.getString("mi_mail"));
				memberInfo.setMi_pw(rs.getString("mi_pw"));
				memberInfo.setMi_nick(rs.getString("mi_nick"));
			}

		} catch (Exception e) {
			System.out.println("MemberInfoDao오류 발샐");
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}
		
		return memberInfo;
	}

}
