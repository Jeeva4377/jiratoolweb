package HelperClasses;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailHelper {

	public static void sendEmailForNotifyMailId(int id, String notify) {

		String receiver = notify;
		String email_message = "your ticket id-" + id + "has been succeffully resolved";

		final String username = "jeevajn905@gmail.com";
		final String password = "inrsftsoixbrwumh";

		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		Session session = Session.getInstance(properties, new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(username, password);
			}
		});

		Message messageBody = new MimeMessage(session);
		try {
			messageBody.setFrom(new InternetAddress(username));
			messageBody.setRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
			messageBody.setSubject("Jira Ticket Update");
			messageBody.setText(email_message);
		} catch (Exception e) {
			System.out.println("sad");

		}

		try {

			Transport.send(messageBody);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getLocalizedMessage());
		}

	}

}
