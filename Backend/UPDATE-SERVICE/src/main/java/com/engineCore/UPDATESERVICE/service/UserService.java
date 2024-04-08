package com.engineCore.UPDATESERVICE.service;

import com.engineCore.UPDATESERVICE.DTO.UserDto;
import com.engineCore.UPDATESERVICE.entity.UserEntity;

public interface UserService {
    UserEntity updateUser(Long id, UserDto userDto);
}
