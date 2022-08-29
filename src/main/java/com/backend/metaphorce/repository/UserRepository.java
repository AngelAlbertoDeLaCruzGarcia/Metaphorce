package com.backend.metaphorce.repository;

import java.util.Optional;

import com.backend.metaphorce.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

	boolean findUsersByUsername(String username);
}
