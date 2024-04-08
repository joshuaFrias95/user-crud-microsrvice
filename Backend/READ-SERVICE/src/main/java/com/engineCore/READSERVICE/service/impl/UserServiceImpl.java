package com.engineCore.READSERVICE.service.impl;

import com.engineCore.READSERVICE.entity.UserEntity;
import com.engineCore.READSERVICE.exception.UserNotFoundExceptionHandler;
import com.engineCore.READSERVICE.repository.UserRepository;
import com.engineCore.READSERVICE.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public List<UserEntity> getAll() {
        log.info("Trayendo a todos los usuarios");
        return userRepository.findAll();
    }

    @Override
    public UserEntity getById(Long id) {
        Optional<UserEntity> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            log.info("Trayendo al usuario con id " + id);
            return optionalUser.get();
        } else {
            throw new UserNotFoundExceptionHandler("Usuario no encontrado", "404");
        }
    }
}
