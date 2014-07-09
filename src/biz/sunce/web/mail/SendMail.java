package biz.sunce.web.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class SendMail {
 
	private static final String USER = "asabo64738@gmail.com";
	private String from;
	private String to;
	private String subject;
	private String text;
 
	public SendMail(String from, String to, String subject, String text){
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.text = text;
	}
 
	public void send(){
 
		Properties props = new Properties();
		final String pas1="nga";
		final String pas2="Ma";
	
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.auth", "true");
		props.setProperty( "mail.smtp.port", "995" );
		props.put("mail.smtp.starttls.enable", "true");
		Session mailSession = Session.getDefaultInstance(props,
		new javax.mail.Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(
		USER, pas2+pas1+1235+"#");//SenderID and Password.
		}
		});
		
		Message simpleMessage = new MimeMessage(mailSession);
 
		InternetAddress fromAddress = null;
		InternetAddress toAddress = null;
		
		try 
		{
			fromAddress = new InternetAddress(from);
			toAddress = new InternetAddress(to);
		} 
		catch (AddressException e) {			
			throw new RuntimeException(e);
		}
 
		try {
			simpleMessage.setFrom(fromAddress);
			simpleMessage.setRecipient(RecipientType.TO, toAddress);
			simpleMessage.setSubject(subject);
			simpleMessage.setText(text);
 
			//Transport transport = mailSession.getTransport("smtp");  
			//transport.connect("smtp.gmail.com", USER, pas2+pas1+123+"!");  
			//transport.send(simpleMessage);
			
			Transport.send(simpleMessage);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
 }
}