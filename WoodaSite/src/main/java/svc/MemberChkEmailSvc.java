package svc;

import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import dao.*;

import java.sql.Connection;

public class MemberChkEmailSvc {

	public String emailChk(String email) {
		String result = "";
		Connection conn = getConnection();
		MemberChkEmailDao memberChkEmailDao = MemberChkEmailDao.getInstance();
		memberChkEmailDao.setConnection(conn);
		
		result = memberChkEmailDao.emailChk(email);
		close(conn);
		
		return result;
	}

}
