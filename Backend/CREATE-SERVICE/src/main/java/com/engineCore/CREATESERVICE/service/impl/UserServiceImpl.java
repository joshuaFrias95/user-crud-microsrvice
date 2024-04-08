package com.engineCore.CREATESERVICE.service.impl;

import com.engineCore.CREATESERVICE.DTO.UserDto;
import com.engineCore.CREATESERVICE.entity.UserEntity;
import com.engineCore.CREATESERVICE.exception.ValidationExceptionHandler;
import com.engineCore.CREATESERVICE.repository.UserRepository;
import com.engineCore.CREATESERVICE.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(UserDto userDto) {

        /*  Exception de validaciones*/
        if (userDto.getUsername() == null || userDto.getUsername().isBlank())
            throw new ValidationExceptionHandler("El campo \"username\" no puede estar vacío", "400");
        if (userDto.getPassword() == null || userDto.getPassword().isBlank())
            throw new ValidationExceptionHandler("El campo \"password\" no puede estar vacío", "400");
        if (userDto.getFirstName() == null || userDto.getFirstName().isBlank())
            throw new ValidationExceptionHandler("El campo \"username\" no puede estar vacío", "400");
        if (userDto.getMiddleName() == null || userDto.getMiddleName().isBlank())
            throw new ValidationExceptionHandler("El campo \"password\" no puede estar vacío", "400");
        if (userDto.getLastName() == null || userDto.getLastName().isBlank())
            throw new ValidationExceptionHandler("El campo \"username\" no puede estar vacío", "400");
        if (userDto.getEmail() == null || userDto.getEmail().isEmpty() || !userDto.getEmail().matches("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b"))
            throw new ValidationExceptionHandler("El correo electrónico no está vacio o no tiene el formato correcto", "400");

        log.info("Crando usuario...");
        UserEntity userEntity = new UserEntity();

        userEntity.setUsername(userDto.getUsername());
        userEntity.setPassword(userDto.getPassword());
        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setMiddleName(userDto.getMiddleName());
        userEntity.setLastName(userDto.getLastName());
        userEntity.setEmail(userDto.getEmail());

        userRepository.save(userEntity);
    }
}
