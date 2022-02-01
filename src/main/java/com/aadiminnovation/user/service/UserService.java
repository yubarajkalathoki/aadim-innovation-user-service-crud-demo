package com.aadiminnovation.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aadiminnovation.user.dto.ContactDto;
import com.aadiminnovation.user.dto.UserCreateDto;
import com.aadiminnovation.user.dto.UserUpdateDto;
import com.aadiminnovation.user.entity.Contact;
import com.aadiminnovation.user.entity.User;
import com.aadiminnovation.user.repository.ContactRepository;
import com.aadiminnovation.user.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ContactRepository contactRepository;

	public User addUser(UserCreateDto request) {
		User user = new User();
		user.setEmail(request.getEmail());
		user.setName(request.getName());
		user.setPassword(request.getPassword());
		user.setMobileNumber(request.getMobileNumber());
		System.out.println("Inserting user");
		userRepository.save(user);

		List<ContactDto> contactRequests = request.getContacts();

		for (int i = 0; i < contactRequests.size(); i++) {
			Contact contact = new Contact();
			contact.setEmail(contactRequests.get(i).getEmail());
			contact.setMobileNumber(contactRequests.get(i).getMobileNumber());
			contact.setUser(user);
			contactRepository.save(contact);
		}
		return user;
	}

	public List<User> getAll() {
		System.out.println("Get all method called from service");
		List<User> users = new ArrayList<>();

		users = (List<User>) userRepository.findAll();

		for (User user : users) {
			List<Contact> contacts = contactRepository.findByUser(user);
			user.setContacts(contacts);
		}

		System.out.println("Users {}"+ users);
		
		return users;
	}

	public void delete(Long id) {
		userRepository.deleteById(id);
	}

	public User update(Long id, UserUpdateDto request) {
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
