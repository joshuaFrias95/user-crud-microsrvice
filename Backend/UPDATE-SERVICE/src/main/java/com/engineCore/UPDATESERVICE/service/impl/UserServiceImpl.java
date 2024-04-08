package com.engineCore.UPDATESERVICE.service.impl;

import com.engineCore.UPDATESERVICE.DTO.UserDto;
import com.engineCore.UPDATESERVICE.entity.UserEntity;
import com.engineCore.UPDATESERVICE.exception.UserNotFoundExceptionHandler;
import com.engineCore.UPDATESERVICE.repository.UserRepository;
import com.engineCore.UPDATESERVICE.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Optional;

@Log4j2
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity updateUser(Long id, UserDto userDto) {

        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);

        if (optionalUserEntity.isPresent()) {
            UserEntity userEntity = optionalUserEntity.get();

            Field[] fields = userDto.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);

                try {
                    Object value = field.get(userDto);

                    if (value != null && !String.valueOf(value).isEmpty()) {
                        log.info("Actualizando usuario...");
                        Field entityField = userEntity.getClass().getDeclaredField(field.getName());
                        entityField.setAccessible(true);
                        entityField.set(userEntity, value);
                    }
                } catch (IllegalAccessException | NoSuchFieldException e) {
                    e.printStackTrace();
                }
            }

            return userRepository.save(userEntity);
        } else {
            throw new UserNotFoundExceptionHandler("Usuario no encontrado", "404");
        }

    }
}
