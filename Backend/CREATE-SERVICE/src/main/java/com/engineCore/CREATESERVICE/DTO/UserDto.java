package com.engineCore.CREATESERVICE.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Pattern(regexp = "\\S+", message = "No es posible agregar espacios a los campos")
public class UserDto {

    @NotBlank(message = "El campo \"username\" no puede estar vacío")
    private String username;

    @NotBlank(message = "El campo \"password\" no puede estar vacío")
    private String password;

    @NotBlank(message = "El campo \"first name\" no puede estar vacío")
    private String firstName;

    @NotBlank(message = "El campo \"middle name\" no puede estar vacío")
    private String middleName;

    @NotBlank(message = "El campo \"last name\" no puede estar vacío")
    private String lastName;

    @NotBlank(message = "El campo \"email\" no puede estar vacío")
    @Email(message = "El correo electrónico no es válido")
    private String email;
}
