package com.just.mvnbook.account.email;

import static org.junit.Assert.*;

import javax.mail.Message;
import javax.mail.internet.MimeMessage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetup;

public class AccountEmailServiceTest   
{  
    private GreenMail greenMail;  
  
    @Before  
    public void startMailServer() throws Exception{  
        greenMail = new GreenMail(ServerSetup.SMTP);  
        greenMail.setUser("justsway@163.com","240ai24");  
        greenMail.start();  
    }  
  
    @Test  
    public void testSendMail() throws Exception{  
    	//ApplicationContext ctx = new FileSystemXmlApplicationContext("X:\\Architecture\\account-email\\src\\resources\\account-email.xml");
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("account-email.xml");
    	AccountEmailService accountEmailService = (AccountEmailService)ctx.getBean("accountEmailService");  
  
        String subject = "Test Subject";  
        String htmlText = "<h3># Another Hello from javamail</h3>";  
        accountEmailService.sendMail("justsway@163.com",subject,htmlText);  
        /*greenMail.waitForIncomingEmail(5000,1);  */
     /*    greenMail.waitForIncomingEmail(2000,1);  
  
        //Message[] msgs = greenMail.getReceivedMessages();  
        MimeMessage[] msgs = greenMail.getReceivedMessages();
        System.out.println("msgs.length="+msgs.length);  
        System.out.println("subject="+msgs[0].getSubject());  
        System.out.println("htmlText="+GreenMailUtil.getBody(msgs[0]).trim());  
  
        assertEquals(1,msgs.length);  
        assertEquals(subject,msgs[0].getSubject());  
        assertEquals(htmlText,GreenMailUtil.getBody(msgs[0]).trim());  */
    }  
  
    @After  
    public void stopMailServer() throws Exception{  
        greenMail.stop();  
    }  
}  