package svc;

import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import dao.*;

import java.sql.Connection;

public class MemberJoinSvc {

	public String goJoin(String email, String name, String nick, String pw, String birth) {
		Connection conn = getConnection();
		MemberJoinDao memberJoinDao = MemberJoinDao.getInstance();
		memberJoinDao.setConnection(conn);
		
		int result = 0;
		
		result = memberJoinDao.goJoin(email, name, nick, pw, birth);
		if (result >= 1)	commit(conn);
		else				rollback(conn);
		close(conn);
		
		
		return result + "";
	}

}
