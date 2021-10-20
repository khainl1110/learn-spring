package com.example.AppApiUsers.service;

import java.util.UUID;

import com.example.AppApiUsers.shared.UserDto;

public class UsersServiceImpl implements UsersService {
	public UserDto createUser(UserDto userDetails) {
		userDetails.setUserId(UUID.randomUUID().toString());
	};
}
