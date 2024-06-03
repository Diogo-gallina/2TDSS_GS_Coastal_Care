package com.coastalcare.controllers;

import com.coastalcare.dto.user.CreateUserDTO;
import com.coastalcare.dto.user.UserDetailsDTO;
import com.coastalcare.models.User;
import com.coastalcare.services.UserService;
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
    public ResponseEntity<UserDetailsDTO> signup(@RequestBody CreateUserDTO userDTO,
                                                 UriComponentsBuilder uri){
        User user = userService.create(userDTO);
        var url = uri.path("/user/{user_id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(url).body(new UserDetailsDTO(user));
    }

    @GetMapping
    public ResponseEntity<Page<UserDetailsDTO>> findAll(Pageable page) {
        var usersList = userService.getAll(page);
        return ResponseEntity.ok(usersList);
    }

}
