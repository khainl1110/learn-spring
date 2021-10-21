package com.example.AppApiUsers.ui.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AppApiUsers.data.UserEntity;
import com.example.AppApiUsers.service.UsersService;
import com.example.AppApiUsers.shared.UserDto;
import com.example.AppApiUsers.ui.model.CreateUserRequestModel;

@RestController
@RequestMapping("/users")
public class UsersController {
	@Autowired
	UsersService usersService;
	
	@GetMapping("/status/check")
	public String status() {
		return "workingfdf";
	}
	
	@GetMapping() 
	public List<UserEntity> getUsers() {
		return (List<UserEntity>) usersService.getAllUsers();
	}
	@PostMapping
	public String createUser(@RequestBody CreateUserRequestModel userDetails) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDto userDto = modelMapper.map(userDetails, UserDto.class);
		usersService.createUser(userDto);
		return "users is called";
	}
}
