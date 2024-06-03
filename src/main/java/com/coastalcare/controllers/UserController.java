package com.coastalcare.controllers;

import com.coastalcare.dto.user.CreateUserDTO;
import com.coastalcare.dto.user.UserDetailsDTO;
import com.coastalcare.models.User;
import com.coastalcare.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

}
