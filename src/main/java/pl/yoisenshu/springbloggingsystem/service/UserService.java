package pl.yoisenshu.springbloggingsystem.service;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.yoisenshu.springbloggingsystem.dto.user.ConfirmEmailDTO;
import pl.yoisenshu.springbloggingsystem.dto.user.RegisterUserDTO;
import pl.yoisenshu.springbloggingsystem.dto.user.RegisteredUserDTO;
import pl.yoisenshu.springbloggingsystem.model.user.AccountStatus;
import pl.yoisenshu.springbloggingsystem.model.user.User;
import pl.yoisenshu.springbloggingsystem.model.user.UserRepository;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public RegisteredUserDTO registerUser(@NotNull RegisterUserDTO registerUserDTO) {

        if(userRepository.existsByEmail(registerUserDTO.getEmail())) {
            throw new IllegalArgumentException("This email address is already in use.");
        }

        if(userRepository.existsByUsername(registerUserDTO.getUsername())) {
            throw new IllegalArgumentException("This username address is already in use.");
        }

        User user = new User(
                registerUserDTO.getUsername(),
                registerUserDTO.getEmail(),
                registerUserDTO.getPassword()
        );

        userRepository.save(user);
        return new RegisteredUserDTO(user);
    }

    public RegisteredUserDTO confirmEmail(@NotNull ConfirmEmailDTO confirmEmailDTO) {

        User user = userRepository.findByUsername(confirmEmailDTO.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("User with given username does not exists."));

        if(!user.getEmailVerificationToken().equals(confirmEmailDTO.getToken())) {
            throw new IllegalArgumentException("Email verification token is incorrect.");
        }

        user.setEmailVerified(true);
        user.setAccountStatus(AccountStatus.ACTIVE);
        userRepository.save(user);
        return new RegisteredUserDTO(user);
    }
}
