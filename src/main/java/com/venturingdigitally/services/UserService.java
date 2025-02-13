package com.venturingdigitally.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.venturingdigitally.entities.User;
import com.venturingdigitally.models.UserBean;
import com.venturingdigitally.repositories.UserRepository;
import com.venturingdigitally.utils.RandomPasswordGeneratorUtil;

import jakarta.mail.MessagingException;

@Service
public class UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private EmailService emailService;

	public User createUser(UserBean userBean) throws MessagingException {
		String password = RandomPasswordGeneratorUtil.generatePassword();

		User user = new User();
		user.setUsername(userBean.getUsername());
		user.setMobile(userBean.getMobile());
		user.setEmail(userBean.getEmail());
		user.setLocation(userBean.getEmail());
		user.setPassword(password);

		userRepository.save(user);
		logger.info("User {} Created Successfully.", user.getId());

		emailService.sendEmail(userBean.getUsername(), userBean.getEmail(), password);

		return user;
	}
}
