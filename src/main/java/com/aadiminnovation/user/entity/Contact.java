package com.aadiminnovation.user.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "contact")
@Getter
@Setter
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String mobileNumber;
	private String email;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
}
