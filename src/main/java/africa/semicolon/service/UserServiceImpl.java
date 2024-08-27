package africa.semicolon.service;

import africa.semicolon.data.model.User;
import africa.semicolon.data.repositories.UserRepository;
import africa.semicolon.dtos.requests.RegisterUserRequest;
import africa.semicolon.dtos.responses.RegisterUserResponse;
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
        response.setMessage("Successful");
        response.setUsername(request.getUsername());
        return response;
    }
}
