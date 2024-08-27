package africa.semicolon.service;

import africa.semicolon.data.repositories.UserRepository;
import africa.semicolon.dtos.requests.LogInRequest;
import africa.semicolon.dtos.requests.RegisterUserRequest;
import africa.semicolon.dtos.responses.LogInResponse;
import africa.semicolon.dtos.responses.RegisterUserResponse;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceImplTest {
    @Autowired
    private UserService userService;
@Transactional
    @Test
    void register() {
        RegisterUserRequest request = new RegisterUserRequest();
        request.setUsername("Victoria");
        request.setPassword("1234");
        RegisterUserResponse response = userService.register(request);
        assertNotNull(response);
        assertThat(response.getMessage()).isEqualTo("Successful");



    }
@Transactional
    @Test
    void login() {
        LogInRequest logInRequest = new LogInRequest();
        RegisterUserRequest request = new RegisterUserRequest();
        request.setUsername("Victoria");
        request.setPassword("1234");
        userService.register(request);

        logInRequest.setUsername("Victoria");
        logInRequest.setPassword("1234");
        LogInResponse response = userService.login(logInRequest);
        assertNotNull(response);
        assertThat(response.getMessage()).isEqualTo("Logged in successfully");



    }
}