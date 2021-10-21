package com.example.AppApiUsers.service;

import com.example.AppApiUsers.data.UserEntity;
import com.example.AppApiUsers.shared.UserDto;

public interface UsersService {
	UserDto createUser(UserDto userDetails);
	Iterable<UserEntity> getAllUsers();
}
