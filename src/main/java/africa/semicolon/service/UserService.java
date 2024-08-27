package africa.semicolon.service;

import africa.semicolon.dtos.requests.RegisterUserRequest;
import africa.semicolon.dtos.responses.RegisterUserResponse;

public interface UserService {
    RegisterUserResponse register (RegisterUserRequest request);
}
