package com.example.springboot.controller;

import com.example.springboot.dto.UserDto;
import com.example.springboot.service.UserService;
import com.example.springboot.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private  final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public ResponseEntity <UserDto>createUser(@RequestBody UserDto userDto) {
        UserDto savedUseResponse =userService.createUser(userDto);
        return ResponseEntity.ok(savedUseResponse);

    }
    @GetMapping("/{id}")
    public ResponseEntity <UserDto> getUserById(@PathVariable Long id) {
        UserDto userResponse = userService.getUserById(id);
        return ResponseEntity.ok(userResponse);
    }

    @GetMapping
    public ResponseEntity <List<UserDto>> getAllUsers() {
        List<UserDto> usersResponse = userService.getAllUsers();
        return ResponseEntity.ok(usersResponse);
    }
    @PutMapping("/{id}")
    public  ResponseEntity <UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        UserDto updatedUserResponse = userService.updateUser(id, userDto);
        return ResponseEntity.ok(updatedUserResponse);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity <String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}