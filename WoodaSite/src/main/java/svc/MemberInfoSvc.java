package svc;

import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.GetNickDao;
import dao.MemberInfoDao;
import vo.MemberInfo;

public class MemberInfoSvc {

	public MemberInfo getInfo(String email) {
		MemberInfo memberInfo = new MemberInfo();
		
		Connection conn = getConnection();
		MemberInfoDao memberInfoDao = MemberInfoDao.getInstance();
		memberInfoDao.setConnection(conn);
		
		memberInfo = memberInfoDao.getInfo(email);
		
		return memberInfo;
	}

}
