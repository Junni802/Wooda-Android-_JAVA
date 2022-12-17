package dao;

import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;

public class BoarderWriteDao {
	private static BoarderWriteDao boarderWriteDao;
	private Connection conn;

	private BoarderWriteDao() {
	}

	public static BoarderWriteDao getInstance() {
		if (boarderWriteDao == null)
			boarderWriteDao = new BoarderWriteDao();
		return boarderWriteDao;
	}

	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	public int writeProc(String email, String nick, String area, String title, String sdate, String edate,
			String content, String lat1, String lng1, String place1, String lat2, String lng2, String place2,
			String lat3, String lng3, String place3, String img1, String img2, String img3) {
		int result = 0;
		Statement stmt = null;
		
		try {

			stmt = conn.createStatement();
			String sql = "insert into t_board_story(mi_mail, mi_nick, bs_area, bs_title, bs_start, bs_end, bs_content, bs_lat1, bs_lng1, bs_place1, bs_lat2, bs_lng2, bs_place2, bs_lat3, bs_lng3, bs_place3, bs_img1, bs_img2, bs_img3) "
					+ "values ('" + email + "', '" + nick + "', '" + area + "', '" + title + "', '" + sdate + "', '" + edate + "', '" + content + "'," +
					" '" + lat1 + "', '" + lng1 + "', '" + place1 + "', '" + lat2 + "', '" + lng2 + "', '" + place2 + "', '" + lat3 + "', '" + lng3 + "', '" + place3 + "', '" + img1 + "', '" + img2 + "', '" + img3 + "')";
			result = stmt.executeUpdate(sql);

		} catch (Exception e) {
			System.out.println("BoarderWriteDao오류 발샐");
			e.printStackTrace();
		} finally {
			close(stmt);
		}
		
		return result;
	}
	
	
	

}
