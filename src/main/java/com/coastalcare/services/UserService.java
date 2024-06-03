package com.coastalcare.services;

import com.coastalcare.dto.user.CreateUserDTO;
import com.coastalcare.dto.user.UserDetailsDTO;
import com.coastalcare.models.User;
import com.coastalcare.repositories.UserRepository;
import com.coastalcare.utils.PasswordUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional
    public User create(CreateUserDTO userDTO) {
        User user = new User(userDTO);
        String hashPassword = PasswordUtil.encoder(user.getPassword());
        user.setPassword(hashPassword);
        return userRepository.save(user);
    }

    public Page<UserDetailsDTO> getAll(Pageable page) {
        return userRepository.findAll(page).map(UserDetailsDTO::new);
    }

}
