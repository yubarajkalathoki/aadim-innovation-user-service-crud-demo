package com.aadiminnovation.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aadiminnovation.user.dto.UserCreateDto;
import com.aadiminnovation.user.dto.UserUpdateDto;
import com.aadiminnovation.user.entity.User;
import com.aadiminnovation.user.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * Default content type application/json
	 * 
	 * @param request
	 */
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public User addUser(@RequestBody UserCreateDto request) {

		System.out.println("Controller method called");
		return userService.addUser(request);
	}

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<User> getAll() {
		System.out.println("Get all method called");
		return userService.getAll();
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		userService.delete(id);
	}

	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public User update(@PathVariable Long id, @RequestBody UserUpdateDto request) {
		return userService.update(id, request);
	}

}
