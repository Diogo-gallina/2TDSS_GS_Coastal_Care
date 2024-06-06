package com.coastalcare.controllers;

import com.coastalcare.dto.user.CreateUserDTO;
import com.coastalcare.dto.user.UserDetailsDTO;
import com.coastalcare.dto.user.UserTypeCountDTO;
import com.coastalcare.models.User;
import com.coastalcare.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

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
    public ResponseEntity<Page<UserDetailsDTO>> findAll(@PageableDefault(sort = "name") Pageable page) {
        var usersList = userService.getAll(page);
        return ResponseEntity.ok(usersList);
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<UserDetailsDTO> findOne(@PathVariable("user_id") Long userId) {
        var user = userService.getOne(userId);
        return ResponseEntity.ok(new UserDetailsDTO(user));
    }

    @GetMapping("/by-name")
    public ResponseEntity<Page<UserDetailsDTO>> findByName(@RequestParam("name") String name,
                                                  Pageable page) {
        var users = userService.findByName(name, page);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/by-email")
    public ResponseEntity<Page<UserDetailsDTO>> findByEmail(@RequestParam("email") String email ,
                                                        Pageable page) {
        var users = userService.findByEmail(email, page);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/by-type")
    public ResponseEntity<Page<UserDetailsDTO>> findByUserType(@RequestParam("type") String type,
                                                        Pageable page) {
        var users = userService.findByUserType(type, page);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/by-type-count")
    public ResponseEntity<List<UserTypeCountDTO>> findByUserType() {
        var userTypesCount = userService.getUsersCountByType();
        return ResponseEntity.ok(userTypesCount);
    }

    @DeleteMapping("/{user_id}")
    public ResponseEntity<Void> delete(@PathVariable("user_id") Long userId) {
        userService.delete(userId);
        return ResponseEntity.noContent().build();
    }

}
