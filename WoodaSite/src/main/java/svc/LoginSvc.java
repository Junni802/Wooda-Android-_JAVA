package svc;

import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import dao.*;

public class LoginSvc {
	public String loginChk(String uid, String upw) {
		String result = "";
		Connection conn = getConnection();
		LoginDao loginDao = LoginDao.getInstance();
		loginDao.setConnection(conn);

		result = loginDao.loginChk(uid, upw);
		close(conn);

		return result;
	}
}
