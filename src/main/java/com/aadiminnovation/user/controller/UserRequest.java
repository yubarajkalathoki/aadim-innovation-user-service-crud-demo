package com.aadiminnovation.user.controller;

import java.util.List;

import com.aadiminnovation.user.entity.Contact;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

	private String name;
	private String email;
	private String password;
	private String mobileNumber;
	private List<ContactRequest> contacts;
}
