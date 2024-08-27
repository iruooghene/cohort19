package africa.semicolon.service;

import africa.semicolon.dtos.requests.LogInRequest;
import africa.semicolon.dtos.requests.RegisterUserRequest;
import africa.semicolon.dtos.responses.LogInResponse;
import africa.semicolon.dtos.responses.RegisterUserResponse;

public interface UserService {
    RegisterUserResponse register (RegisterUserRequest request);
    LogInResponse login (LogInRequest logInRequest);
}
