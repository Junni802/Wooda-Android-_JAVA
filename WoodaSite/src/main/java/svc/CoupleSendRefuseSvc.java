package svc;

import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import dao.*;

import java.sql.Connection;

public class CoupleSendRefuseSvc {

	public String sendDelete(String email) {
		Connection conn = getConnection();
		CoupleSendRefuseDao coupleSendRefuseDao = CoupleSendRefuseDao.getInstance();
		coupleSendRefuseDao.setConnection(conn);
		
		int result = 0;
		
		result = coupleSendRefuseDao.sendDelete(email);
		if (result >= 1)	commit(conn);
		else				rollback(conn);
		close(conn);
		
		
		return result + "";
		
	}

}
