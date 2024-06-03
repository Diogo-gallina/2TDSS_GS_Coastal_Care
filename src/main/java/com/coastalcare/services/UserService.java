package com.coastalcare.services;

import com.coastalcare.dto.user.CreateUserDTO;
import com.coastalcare.models.User;
import com.coastalcare.repositories.UserRepository;
import com.coastalcare.utils.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User create(CreateUserDTO userDTO) {
        User user = new User(userDTO);
        String hashPassword = PasswordUtil.encoder(user.getPassword());
        user.setPassword(hashPassword);
        return userRepository.save(user);
    }

}
