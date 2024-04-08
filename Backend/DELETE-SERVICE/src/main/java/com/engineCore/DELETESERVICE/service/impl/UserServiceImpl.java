package com.engineCore.DELETESERVICE.service.impl;

import com.engineCore.DELETESERVICE.entity.UserEntity;
import com.engineCore.DELETESERVICE.exception.UserNotFoundExceptionHandler;
import com.engineCore.DELETESERVICE.repository.UserRepository;
import com.engineCore.DELETESERVICE.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Log4j2
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public void deleteUserById(Long id) {
        Optional<UserEntity> user = userRepository.findById(id);

        if (user.isPresent()) {
            log.info("Eliminando usuario con id " + id);
            userRepository.delete(user.get());
        } else {
            log.info("Usuario con " + id + " no fue encontrado");
            throw new UserNotFoundExceptionHandler("Usuario no encontrado", "404");
        }

    }
}
