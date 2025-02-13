package com.venturingdigitally.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import com.venturingdigitally.constants.AppConstants;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender emailSender;

	public void sendEmail(String user, String sentTo, String password) throws MessagingException {
		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setFrom("sbarande31@gmail.com");
		helper.setTo(sentTo);
		helper.setSubject(AppConstants.ACCOUNT_CREATION_SUBJECT);
		helper.setText(String.format(AppConstants.MESSAGE, user, password));

		emailSender.send(message);
	}
}
