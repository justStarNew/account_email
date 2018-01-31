package com.just.mvnbook.account.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

/**
 * 
 * @author 085
 *
 */
public class AccountEmailServiceImpl implements AccountEmailService {

	private JavaMailSender javaMailSender;
	
	private String systemEmail;
	
	public void sendMail(String to, String subject, String htmlText)
			throws AccountEmailException {
		
		try{
			MimeMessage msg = javaMailSender.createMimeMessage();
			MimeMessageHelper msgHelper = new MimeMessageHelper(msg);
			
			msgHelper.setFrom(systemEmail);
			msgHelper.setTo(to);
			msgHelper.setSubject(subject);
			//true 代表邮件的内容为html格式。
			msgHelper.setText(htmlText,true);
			
			javaMailSender.send(msg);
		} catch(MessagingException e) {
			//throw new AccountEmailException("fail to send mail.",e);
			System.out.println("fail to send mail."+e.toString());
		}	
	}

	public JavaMailSender getJavaMailSender() {
		return javaMailSender;
	}

	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public String getSystemEmail() {
		return systemEmail;
	}

	public void setSystemEmail(String systemEmail) {
		this.systemEmail = systemEmail;
	}
	
	

}
