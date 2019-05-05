package com.klicks.klicks.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.klicks.klicks.entities.User;

@Service
public class MailService {
	private JavaMailSender javaMailSender;

	@Autowired
	public MailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void sendMail(User user) throws MailException {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom("kati@gmail.com");
		mail.setTo(user.getEmail());
		mail.setSubject("Confirm registration");
		mail.setText("Enable your account through this link <a href=\" + temp + \">Click here</a>");
		javaMailSender.send(mail);
	}
}
