package com.clubify.ws.auth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clubify.ws.shared.CurrentUser;
import com.clubify.ws.shared.Views;
import com.clubify.ws.user.User;
import com.clubify.ws.user.UserRepository;
import com.fasterxml.jackson.annotation.JsonView;


@RestController
public class AuthController {
	
	@Autowired
	UserRepository userRepository;
	
	
	@PostMapping("/api/1.0/auth")
	@JsonView(Views.Base.class)
	ResponseEntity<?> handleAuthentication(@CurrentUser User user) {
 		return ResponseEntity.ok(user);
	}

}
