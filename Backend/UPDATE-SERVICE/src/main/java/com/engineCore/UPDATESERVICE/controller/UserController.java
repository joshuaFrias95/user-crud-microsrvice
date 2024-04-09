package com.engineCore.UPDATESERVICE.controller;

import com.engineCore.UPDATESERVICE.DTO.UserDto;
import com.engineCore.UPDATESERVICE.entity.UserEntity;
import com.engineCore.UPDATESERVICE.service.UserService;
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

    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        UserEntity user = userService.updateUser(id, userDto);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
