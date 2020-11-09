package com.services;

import com.model.User;
import com.repository.UserRepository;

public class UserService {
private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	
	public void saveMyUser(User user ) {
		userRepository.save(user);
	}

}
