package com.aadiminnovation.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aadiminnovation.user.controller.ContactRequest;
import com.aadiminnovation.user.controller.UserRequest;
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

	public User addUser(UserRequest request) {
		User user = new User();
		user.setEmail(request.getEmail());
		user.setName(request.getName());
		user.setPassword(request.getPassword());
		user.setMobileNumber(request.getMobileNumber());
		System.out.println("Inserting user");
		userRepository.save(user);

		List<ContactRequest> contactRequests = request.getContacts();

		List<Contact> contacts = new ArrayList<>();

//		 c style
		for (int i = 0; i < contactRequests.size(); i++) {
			Contact contact = new Contact();
			contact.setEmail(contactRequests.get(i).getEmail());
			contact.setMobileNumber(contactRequests.get(i).getMobileNumber());
			contact.setUser(user);
			contacts.add(contact);
		}
		// for each loop / enhanced loop
//		for(Contact contact: contacts) {
//			contact.setUser(user);
//		}

		contactRepository.saveAll(contacts);
		user.setContacts(contacts);
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
