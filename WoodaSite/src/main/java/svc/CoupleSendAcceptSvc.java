package svc;

import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import dao.*;

public class CoupleSendAcceptSvc {

	public String sendDelete(String memail, String uemail) {
		Connection conn = getConnection();
		CoupleSendAcceptDao coupleSendAcceptDao = CoupleSendAcceptDao.getInstance();
		coupleSendAcceptDao.setConnection(conn);
		
		int result = 0;
		
		result = coupleSendAcceptDao.sendDelete(memail, uemail);
		if (result >= 1)	commit(conn);
		else				rollback(conn);
		close(conn);
		
		
		return result + "";
	}

}
