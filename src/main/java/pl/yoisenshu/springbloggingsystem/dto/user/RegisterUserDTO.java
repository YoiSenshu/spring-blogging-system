package pl.yoisenshu.springbloggingsystem.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RegisterUserDTO {

    private String username;
    private String email;
    private String password;
}
