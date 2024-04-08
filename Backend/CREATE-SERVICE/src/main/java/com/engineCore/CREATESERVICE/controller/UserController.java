package com.engineCore.CREATESERVICE.controller;


import com.engineCore.CREATESERVICE.DTO.UserDto;
import com.engineCore.CREATESERVICE.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<String> createUser(@RequestBody UserDto userDto) {
        userService.createUser(userDto);

        return new ResponseEntity<>("Usuario creado satisfactoriamente", HttpStatus.CREATED);
    }
}
