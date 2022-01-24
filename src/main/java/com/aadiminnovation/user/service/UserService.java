package com.aadiminnovation.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aadiminnovation.user.controller.UserRequest;
import com.aadiminnovation.user.entity.User;
import com.aadiminnovation.user.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User addUser(UserRequest request) {
		User user = new User();
		user.setEmail(request.getEmail());
		user.setName(request.getName());
		user.setPassword(request.getPassword());
		user.setMobileNumber(request.getMobileNumber());
		return userRepository.save(user);
	}

	public Iterable<User> getAll() {
		return userRepository.findAll();
	}

	public void delete(Long id) {
		userRepository.deleteById(id);
	}

	public User update(Long id, UserRequest request) {
		// find user by id and set the new values
		Optional<User> optional = userRepository.findById(id);
		if (optional.isPresent()) {
			User user = optional.get();
			user.setEmail(request.getEmail());
			user.setName(request.getName());
			user.setPassword(request.getPassword());
			user.setMobileNumber(request.getMobileNumber());
			return userRepository.save(user);
		}
		return null;
	}

}
