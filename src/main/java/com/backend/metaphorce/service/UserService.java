package com.backend.metaphorce.service;

import com.backend.metaphorce.entity.Contract;
import com.backend.metaphorce.entity.User;
import com.backend.metaphorce.repository.ContractRepository;
import com.backend.metaphorce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }


    @Transactional(readOnly = true)
    public boolean findUser(String username) {
        return userRepository.findUsersByUsername(username);
    }

}
