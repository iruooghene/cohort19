package africa.semicolon.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserRequest {
    private String username;
    private String password;
}
