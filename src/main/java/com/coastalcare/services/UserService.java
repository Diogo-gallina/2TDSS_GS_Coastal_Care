package com.coastalcare.services;

import com.coastalcare.dto.user.CreateUserDTO;
import com.coastalcare.dto.user.UserDetailsDTO;
import com.coastalcare.infra.exceptions.PasswordConfirmationException;
import com.coastalcare.models.User;
import com.coastalcare.repositories.UserRepository;
import com.coastalcare.utils.PasswordUtil;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional
    public User create(@Valid CreateUserDTO userDTO) {
        if (!userDTO.password().equals(userDTO.passwordConfirmation())) throw new PasswordConfirmationException();

        User user = new User(userDTO);
        String hashPassword = PasswordUtil.encoder(user.getPassword());
        user.setPassword(hashPassword);
        return userRepository.save(user);
    }

    public Page<UserDetailsDTO> getAll(Pageable page) {
        return userRepository.findAll(page).map(UserDetailsDTO::new);
    }

    public User getOne(Long userId) {
        return userRepository.getReferenceById(userId);
    }

    @Transactional
    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }

}
