package com.aadiminnovation.user.repository;

import org.springframework.data.repository.CrudRepository;

import com.aadiminnovation.user.entity.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long> {

}
