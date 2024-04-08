package com.engineCore.READSERVICE.service;

import com.engineCore.READSERVICE.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> getAll();

    UserEntity getById(Long id);
}
