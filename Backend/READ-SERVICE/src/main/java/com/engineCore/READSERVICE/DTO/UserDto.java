package com.engineCore.READSERVICE.DTO;

import lombok.*;

@Data @Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long userId;
    private String username;
    private String password;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
}
