package svc;

import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import dao.*;

import java.sql.Connection;

public class BoarderWriteSvc {

	public String writeProc(String email, String nick, String area, String title, String sdate, String edate,
			String content, String lat1, String lng1, String place1, String lat2, String lng2, String place2,
			String lat3, String lng3, String place3, String img1, String img2, String img3) {
		int result = 0;
		Connection conn = getConnection();
		BoarderWriteDao boarderWriteDao = BoarderWriteDao.getInstance();
		boarderWriteDao.setConnection(conn);
		
		result = boarderWriteDao.writeProc(email, nick, area, title, sdate, edate, 
				content, lat1, lng1, place1, lat2, lng2, place2, lat3, lng3, place3, img1, img2, img3);
		if (result >= 1)	commit(conn);
		else				rollback(conn);
		close(conn);
		
		return result + "";
	}

}
