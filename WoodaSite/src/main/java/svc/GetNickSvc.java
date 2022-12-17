package svc;


import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import dao.*;

import java.sql.Connection;

import dao.GetNickDao;
import dao.LoginDao;

public class GetNickSvc {

	public String getNick(String email) {
		String result = "";
		Connection conn = getConnection();
		GetNickDao getNickDao = GetNickDao.getInstance();
		getNickDao.setConnection(conn);
		
		result = getNickDao.getNick(email);
		close(conn);
		
		return result;
	}

}
