package com.allianz.dao.daoInterface;

import java.util.List;
import java.util.Set;

import com.allianz.dto.UserDto;


public interface UserDaoInterface {
	public UserDto userDetailById(int userId);
	public List<UserDto> getAllUsers();
	public UserDto addUser(UserDto user);
}
