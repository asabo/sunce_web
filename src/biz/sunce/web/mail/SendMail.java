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
 
public final class SendMail {
 	 
	private String from;
	private String to;
	private String subject;
	private String text;
	private Properties props;
 
	public SendMail(String from, String to, String subject, String text, Properties props){
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.text = text;
		this.props = props;
	}
 
	public void send(){
 
		 final String u = props.getProperty("kor");
		 final String p = props.getProperty("loza");

		Session mailSession = Session.getDefaultInstance(props,
		new javax.mail.Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(
		u, p);
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
  		 
			Transport.send(simpleMessage);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
 }
}