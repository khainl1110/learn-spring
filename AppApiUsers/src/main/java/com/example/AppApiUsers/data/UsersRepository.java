package com.example.AppApiUsers.data;

import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<UserEntity, Long> {
	// by doing this, we can call the repository and it will do the heavy lifting for us
}
