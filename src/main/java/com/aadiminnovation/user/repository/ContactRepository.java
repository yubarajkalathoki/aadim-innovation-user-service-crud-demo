package com.aadiminnovation.user.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.aadiminnovation.user.entity.Contact;
import com.aadiminnovation.user.entity.User;

public interface ContactRepository extends CrudRepository<Contact, Long> {

	List<Contact> findByUser(User user);

	List<Contact> findByUserId(Long id);

// delete from contact where user_id = givenId
	void deleteByUserId(Long id);
	
// delete from contact where email = givenEmail
	void deleteByUserEmail(String givenEmail);

}
