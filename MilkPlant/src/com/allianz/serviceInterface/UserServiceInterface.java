package com.allianz.serviceInterface;

import java.util.Set;

import com.allianz.dto.UserDto;


public interface UserServiceInterface {
	public UserDto getUserById(int userId);
	public Set<String> getUserType();
	public UserDto addUser(UserDto user);

}
