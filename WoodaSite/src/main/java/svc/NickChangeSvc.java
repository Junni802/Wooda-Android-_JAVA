package svc;

import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import dao.*;
import java.sql.Connection;

public class NickChangeSvc {

	public String changeNick(String email, String nick) {
		Connection conn = getConnection();
		NickChangeDao nickChangeDao = NickChangeDao.getInstance();
		nickChangeDao.setConnection(conn);
		
		int result = 0;
		
		result = nickChangeDao.changPassword(email, nick);
		if (result >= 1)	commit(conn);
		else				rollback(conn);
		close(conn);
		
		
		return result + "";
	}

}
