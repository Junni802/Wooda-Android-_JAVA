package svc;

import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import dao.*;

import java.sql.Connection;

public class CoupleSendSvc {

	public String sendCouple(String sEmail, String rEmail, String endDate) {
		Connection conn = getConnection();
		CoupleSendDao coupleSendDao = CoupleSendDao.getInstance();
		coupleSendDao.setConnection(conn);
		
		int result = 0;
		
		result = coupleSendDao.sendCouple(sEmail, rEmail, endDate);
		if (result >= 1)	commit(conn);
		else				rollback(conn);
		close(conn);
		
		
		return result + "";
	}

}
