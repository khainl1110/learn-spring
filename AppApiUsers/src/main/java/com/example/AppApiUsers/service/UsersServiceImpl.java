package com.example.AppApiUsers.service;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AppApiUsers.data.UserEntity;
import com.example.AppApiUsers.data.UsersRepository;
import com.example.AppApiUsers.shared.UserDto;

@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	UsersRepository usersRepository;
	public Iterable<UserEntity> getAllUsers() {
		return usersRepository.findAll();
	}
	public UserDto createUser(UserDto userDetails) {
		userDetails.setUserId(UUID.randomUUID().toString());
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity userEntity = modelMapper.map(userDetails, UserEntity.class);
		userEntity.setEncryptedPassword("Test");
		// in order to match, the fields name must match
		usersRepository.save(userEntity);
		return userDetails;
	};
}
