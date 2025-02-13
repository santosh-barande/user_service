package com.venturingdigitally.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.venturingdigitally.models.UserBean;
import com.venturingdigitally.services.UserService;
import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/create")
	public ResponseEntity<String> createUser(@RequestBody UserBean userBean) {
		try {
			userService.createUser(userBean);
			return ResponseEntity.ok("User created and password sent to email!");
		} catch (MessagingException e) {
			return ResponseEntity.status(500).body("Error sending email: " + e.getMessage());
		}
	}
}
