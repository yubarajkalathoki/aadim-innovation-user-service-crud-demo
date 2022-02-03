package com.aadiminnovation.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aadiminnovation.user.dto.ContactCreateDto;
import com.aadiminnovation.user.dto.ContactDto;
import com.aadiminnovation.user.dto.UserCreateDto;
import com.aadiminnovation.user.dto.UserListResponseDto;
import com.aadiminnovation.user.dto.UserResponseDto;
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

	public UserResponseDto addUser(UserCreateDto request) {
		User user = new User();
		user.setEmail(request.getEmail());
		user.setName(request.getName());
		user.setPassword(request.getPassword());
		user.setMobileNumber(request.getMobileNumber());
		System.out.println("Inserting user");
		User savedUser = userRepository.save(user);

		List<ContactDto> contactRequests = request.getContacts();
		saveContacts(user, contactRequests);
		return getUserResponseDto(savedUser);
	}

	private void saveContacts(User user, List<ContactDto> contactRequests) {
		if (contactRequests == null)
			return;
		for (int i = 0; i < contactRequests.size(); i++) {
			Contact contact = new Contact();
			contact.setEmail(contactRequests.get(i).getEmail());
			contact.setMobileNumber(contactRequests.get(i).getMobileNumber());
			contact.setUser(user);
			contactRepository.save(contact);
		}
	}

	private UserResponseDto getUserResponseDto(User savedUser) {
		UserResponseDto response = new UserResponseDto();
		response.setEmail(savedUser.getEmail());
		response.setId(savedUser.getId());
		response.setMobileNumber(savedUser.getMobileNumber());
		response.setName(savedUser.getName());
		response.setPassword(savedUser.getPassword());

		List<Contact> contacts = contactRepository.findByUserId(savedUser.getId());

		List<ContactDto> contactDtoList = new ArrayList<>();

		for (Contact contact : contacts) {
			ContactDto dto = new ContactDto();
			dto.setEmail(contact.getEmail());
			dto.setMobileNumber(contact.getEmail());
			contactDtoList.add(dto);
		}
		response.setContacts(contactDtoList);
		return response;
	}

	public UserListResponseDto getAll() {
		System.out.println("Get all method called from service");
		List<UserResponseDto> userResponseList = new ArrayList<>();

		List<User> users = (List<User>) userRepository.findAll();

		for (User user : users) {
			userResponseList.add(getUserResponseDto(user));
		}
		System.out.println("Users {}" + users);

		UserListResponseDto response = new UserListResponseDto();
		response.setUsers(userResponseList);
		response.setTotal(userResponseList.size());
		return response;
	}

	/**
	 * Implementation logic is:
	 * <p>
	 * <li>First delete the contact associated with given userId</li>
	 * <li>Then only delete the user by id</li>
	 * 
	 * @param id
	 */
	@Transactional
	public void delete(Long id) {
		// case 1
		contactRepository.deleteByUserId(id);
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

	public UserResponseDto get(Long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		if (optionalUser.isPresent()) {
			return getUserResponseDto(optionalUser.get());
		}
		return null;
	}

	public UserResponseDto saveContacts(Long id, ContactCreateDto dto) {
		Optional<User> optionalUser = userRepository.findById(id);
		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			for (int i = 0; i < dto.getContacts().size(); i++) {
				Contact contact = new Contact();
				ContactDto contactDto = dto.getContacts().get(i);
				contact.setEmail(contactDto.getEmail());
				contact.setMobileNumber(contactDto.getMobileNumber());
				contact.setUser(user);
				contactRepository.save(contact);
			}
			return getUserResponseDto(user);
		}

		return null;
	}

	@Transactional
	public void emailBataDeleteGar(String furkesaliEmail) {
		
		contactRepository.deleteByUserEmail(furkesaliEmail);
		
		userRepository.deleteByEmail(furkesaliEmail);
	}
}
