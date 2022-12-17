package svc;

import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import dao.*;

import java.sql.Connection;

import dao.GetNickDao;
import dao.LoginDao;

public class MemberPwChangeSvc {

	public String changPassword(String email, String pw) {
		Connection conn = getConnection();
		MemberPwChangeDao memberPwChangeDao = MemberPwChangeDao.getInstance();
		memberPwChangeDao.setConnection(conn);
		
		int result = 0;
		
		result = memberPwChangeDao.changPassword(email, pw);
		if (result >= 1)	commit(conn);
		else				rollback(conn);
		close(conn);
		
		
		return result + "";
	}

}
