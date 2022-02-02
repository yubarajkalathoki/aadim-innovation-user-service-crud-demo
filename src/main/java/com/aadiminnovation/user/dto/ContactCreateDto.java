package com.aadiminnovation.user.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

public class ContactCreateDto {
	@NotNull(message = "At least one contact is required")
	private List<ContactDto> contacts;

	public List<ContactDto> getContacts() {
		return contacts;
	}

	public void setContacts(List<ContactDto> contacts) {
		this.contacts = contacts;
	}
	
}
