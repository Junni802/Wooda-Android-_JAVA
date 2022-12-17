package svc;

import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import dao.*;

import java.sql.Connection;

public class ExitEmailSvc {

	public String geExitEmail(String email) {
		String num = "";
		Connection conn = getConnection();
		ExitEmailDao exitEmailDao = ExitEmailDao.getInstance();
		exitEmailDao.setConnection(conn);
		
		num = exitEmailDao.geExitEmail(email);
		close(conn);
		
		return num;
	}

}
