package svc;

import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import dao.*;
import vo.CoupleInfo;

import java.sql.Connection;

public class CoupleRecieveSvc {

	public String checkReciever(String email) {
		String mail = "";
		Connection conn = getConnection();
		CoupleRecieveDao coupleRecieveDao = CoupleRecieveDao.getInstance();
		coupleRecieveDao.setConnection(conn);
		
		mail = coupleRecieveDao.checkReciever(email);
		close(conn);
		
		return mail;
	}

}
