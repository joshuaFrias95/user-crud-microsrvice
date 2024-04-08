package com.engineCore.CREATESERVICE.controller;

import com.engineCore.CREATESERVICE.DTO.UserDto;
import com.engineCore.CREATESERVICE.exception.ValidationExceptionHandler;
import com.engineCore.CREATESERVICE.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserControllerTest {

    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    /**
     * Test de validación de ingreso de datos correctos -> Pasa
     * @throws Exception
     * Este test está enfocado en testear que los datos puedan ser ingresados de la manera esperada
     */
    @Test
    public void createUserTest_Success() throws Exception {

        UserDto userDto = new UserDto();
        userDto.setUsername("testUsername");
        userDto.setPassword("testPassword");
        userDto.setFirstName("testFirstName");
        userDto.setLastName("testLastName");
        userDto.setEmail("test@example.com");

        doNothing().when(userService).createUser(any(UserDto.class));

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/user") // Usa MockMvcRequestBuilders.post()
                        .contentType(MediaType.APPLICATION_JSON).content("{\"username\":\"testUser\",\"password\":\"testPassword\",\"firstName\":\"Test\",\"lastName\":\"User\",\"email\":\"test@example.com\"}"))
                .andExpect(status().isCreated());
    }

    /**
     * Test de validación campos vacios -> Fallo
     * @throws Exception
     * Este test está enfocado en testear que ningún camṕo quede vacío o nulo
     */
    @Test
    public void createUserTest_Fail_EmptyFields() throws Exception {
        UserDto userDto = new UserDto(); // Todos los campos vacíos

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\":\"\",\"password\":\"\",\"firstName\":\"\",\"lastName\":\"\",\"email\":\"\"}"))
                .andExpect(status().isBadRequest());
    }

    /**
     * Test de validación de email -> Fallo
     * @throws Exception
     * Este test está enfocado en testear que se dispare un exception al ingresar un formato inválido en el email.
     */
    @Test
    public void createUserTest_Fail_InvalidEmail() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setUsername("testUsername");
        userDto.setPassword("testPassword");
        userDto.setFirstName("testFirstName");
        userDto.setLastName("testLastName");
        userDto.setEmail("invalidEmail"); // Email inválido

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\":\"testUser\",\"password\":\"testPassword\",\"firstName\":\"Test\",\"lastName\":\"User\",\"email\":\"invalidEmail\"}"))
                .andExpect(status().isBadRequest());
    }
}
