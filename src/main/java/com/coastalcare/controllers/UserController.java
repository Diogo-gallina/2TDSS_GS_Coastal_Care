package com.coastalcare.controllers;

import com.coastalcare.dto.user.CreateUserDTO;
import com.coastalcare.dto.user.UserDetailsDTO;
import com.coastalcare.models.User;
import com.coastalcare.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<UserDetailsDTO> signup(@RequestBody @Valid CreateUserDTO userDTO,
                                                 UriComponentsBuilder uri) {
        User user = userService.create(userDTO);
        var url = uri.path("/users/{user_id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(url).body(new UserDetailsDTO(user));
    }

    @GetMapping
    public ResponseEntity<Page<UserDetailsDTO>> findAll(Pageable page) {
        var usersList = userService.getAll(page);
        return ResponseEntity.ok(usersList);
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<UserDetailsDTO> findOne(@PathVariable("user_id") Long id) {
        var user = userService.getOne(id);
        return ResponseEntity.ok(new UserDetailsDTO(user));
    }

}
