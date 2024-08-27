package africa.semicolon.service;

import africa.semicolon.data.model.User;
import africa.semicolon.data.repositories.UserRepository;
import africa.semicolon.dtos.requests.LogInRequest;
import africa.semicolon.dtos.requests.RegisterUserRequest;
import africa.semicolon.dtos.responses.LogInResponse;
import africa.semicolon.dtos.responses.RegisterUserResponse;
import africa.semicolon.exception.InvalidUserException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private  final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public RegisterUserResponse register(RegisterUserRequest request) {
        User user = modelMapper.map(request, User.class);
        userRepository.save(user);
        RegisterUserResponse response = new RegisterUserResponse();
        response.setMessage("Successfully registered");
        response.setUsername(request.getUsername());
        return response;
    }

    @Override
    public LogInResponse login(LogInRequest logInRequest) {
        User user = userRepository.findByUsername(logInRequest.getUsername());
        if(user == null || !user.getPassword().equals(logInRequest.getPassword())){
            throw new InvalidUserException("Invalid details");
        }
        User user1 = modelMapper.map(logInRequest, User.class);
        user1.setIsLoggedIn(true);
        userRepository.save(user1);

        LogInResponse response = new LogInResponse();
        response.setMessage("Logged in successfully");
        response.setLoggedIn(true);
       return response;

    }
}
