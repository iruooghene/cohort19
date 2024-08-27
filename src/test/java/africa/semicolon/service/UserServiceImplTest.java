package africa.semicolon.service;

import africa.semicolon.data.repositories.UserRepository;
import africa.semicolon.dtos.requests.RegisterUserRequest;
import africa.semicolon.dtos.responses.RegisterUserResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Test
    void register() {
        RegisterUserRequest request = new RegisterUserRequest();
        request.setUsername("Victoria");
        request.setPassword("1234");
        RegisterUserResponse response = userService.register(request);
        assertNotNull(response);
        assertTrue(response.getMessage().equals("Successfully registered"));

    }
}