import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailController {
	public static void sendMail(String studentMessage) throws Exception {
		String myEmailAccount = "grace.haruka.233@gmail.com";
		String myEmailPassword = "nvymzlpbxpmzrtix";
		String myEmailSMTPHost = "smtp.gmail.com";
		String receiveMailAccount = "s3672010@student.rmit.edu.au";

		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.smtp.host", myEmailSMTPHost);
		props.setProperty("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");  
	    props.put("mail.debug", "true");  
	    props.put("mail.smtp.socketFactory.port", "465");  
	    props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
	    props.put("mail.smtp.socketFactory.fallback", "false");
		Session session = Session.getInstance(props);
		Transport transport;
		MimeMessage message = createMimeMessage(session, myEmailAccount, receiveMailAccount, studentMessage);
		transport = session.getTransport();
		transport.connect(myEmailAccount, myEmailPassword);
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();

	}

	public static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail,
			String studentMessage) throws Exception {
		MimeMessage message = new MimeMessage(session);

		message.setFrom(new InternetAddress(sendMail, "Bo Feng And Yating Li", "UTF-8"));

		message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "Teacher Han", "UTF-8"));

		message.setSubject("Port Number", "UTF-8");

		message.setContent(studentMessage, "text/html;charset=UTF-8");

		message.saveChanges();

		return message;
	}

}
