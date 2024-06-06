package com.coastalcare.services;

import com.coastalcare.dto.user.CreateUserDTO;
import com.coastalcare.dto.user.UserDetailsDTO;
import com.coastalcare.dto.user.UserTypeCountDTO;
import com.coastalcare.infra.exceptions.PasswordConfirmationException;
import com.coastalcare.models.User;
import com.coastalcare.models.enums.UserType;
import com.coastalcare.repositories.UserRepository;
import com.coastalcare.utils.PasswordUtil;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


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

    public Page<UserDetailsDTO> findByName(String name, Pageable page) {
        return userRepository.findByName(name, page).map(UserDetailsDTO::new);
    }

    public Page<UserDetailsDTO> findByEmail(String email, Pageable page) {
        return userRepository.findByEmail(email, page).map(UserDetailsDTO::new);
    }

    public Page<UserDetailsDTO> findByUserType(String type, Pageable page) {
        return userRepository.findByUserType(type, page).map(UserDetailsDTO::new);
    }

    public List<UserTypeCountDTO> getUsersCountByType() {
        var results = userRepository.countUsersByType();
        return results.stream()
                .map(result -> new UserTypeCountDTO((UserType) result[0], (Long) result[1]))
                .toList();
    }

    @Transactional
    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }

}
