package test1;

import javax.mail.*;

public class NaverAuthentication extends Authenticator {
	PasswordAuthentication passAuth;
	
	public NaverAuthentication() {
		passAuth = new PasswordAuthentication("manggo802", "@83366174a");
	}
	public PasswordAuthentication getPasswordAuthentication() {
		return passAuth;
	}
}
