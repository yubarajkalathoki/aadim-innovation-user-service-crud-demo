package com.aadiminnovation.user.dto;

import java.util.List;

public class UserListResponseDto {
	private List<UserResponseDto> users;
	private int total;
	public List<UserResponseDto> getUsers() {
		return users;
	}
	public void setUsers(List<UserResponseDto> users) {
		this.users = users;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	
}
