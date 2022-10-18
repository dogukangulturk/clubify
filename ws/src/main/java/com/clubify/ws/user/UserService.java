package com.clubify.ws.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	UserRepository userRepository;
	
	
	//@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}



	public void save(User user) {
		userRepository.save(user);
	}

}