package svc;

import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import dao.*;

import java.sql.Connection;

public class MemberChkNickSvc {

	public String NickChk(String nick) {
		String result = "";
		Connection conn = getConnection();
		MemberChkNickDao memberChkNickDao = MemberChkNickDao.getInstance();
		memberChkNickDao.setConnection(conn);
		
		result = memberChkNickDao.NickChk(nick);
		close(conn);
		
		return result;
	}

}
