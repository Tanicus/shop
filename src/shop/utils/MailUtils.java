package shop.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * �ʼ����͹�����
 * 
 * @author Programmer
 *
 */
public class MailUtils {

	/**
	 * �����ʼ��ķ���
	 * 
	 * @param to   ���ռ���
	 * @param code ��������
	 */
	public static void sendMail(String to, String code) {
		//1.���һ��Session����
		Properties props = new Properties();
		props.setProperty("mail.host", "localhost");
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("service@shop.com", "111");
			}
		});
		//2.����һ�������ʼ��Ķ���Message
		Message message = new MimeMessage(session);
		try {
			// ���÷�����
			message.setFrom(new InternetAddress("service@shop.com"));
			
			// �����ռ���
			message.setRecipient(RecipientType.TO, new InternetAddress(to));
			
			// ���ñ���
			message.setSubject("��ӭע��zzg�̳ǣ�");
			
			// ��������
			message.setContent("<h1>zzg�̳ǹٷ������ʼ��������·�������ɼ��������</h1><h3><a href='http://192.168.0.101:8080/shop/user_active.action?code="+code+"'>http://192.168.0.100:8080/shop/user_active.action?code="+code+"</a></h3>", "text/html;charset=UTF-8");
			
			//3.�����ʼ�Transport
			Transport.send(message);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		sendMail("aaa@shop.com", "12346789abcdefg");
	}
}
