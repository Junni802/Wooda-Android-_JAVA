package test1;

import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

public class test {

	public String mail(String sender, String receiver, String title, String content) {
		try {
			Properties properties = System.getProperties();
			properties.put("mail.smtp.starttls.enable", "true");
			properties.put("mail.smtp.host", "smtp.naver.com");
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.port", "587");

			Authenticator auth = new NaverAuthentication();
			Session s = Session.getDefaultInstance(properties, auth);
			Message msg = new MimeMessage(s);
			Address senderAddr = new InternetAddress(sender);
			Address receiverAddr = new InternetAddress(receiver);

			msg.setHeader("content-type", "text/html; charset=utf-8");
			msg.setFrom(senderAddr);
			msg.addRecipient(Message.RecipientType.TO, receiverAddr);
			msg.setSubject(title);
			msg.setContent(content, "text/html; charset=utf-8");
			msg.setSentDate(new java.util.Date());

			Transport.send(msg);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return content;
	}

}
