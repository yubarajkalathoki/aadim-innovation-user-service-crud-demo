package com.aadiminnovation.user.repository;

import org.springframework.data.repository.CrudRepository;

import com.aadiminnovation.user.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

	void deleteByEmail(String furkesali);

}
