package pl.yoisenshu.springbloggingsystem.service;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.yoisenshu.springbloggingsystem.dto.user.RegisterUserDTO;
import pl.yoisenshu.springbloggingsystem.dto.user.UserDataDTO;
import pl.yoisenshu.springbloggingsystem.model.user.User;
import pl.yoisenshu.springbloggingsystem.model.user.UserRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Optional<UserDataDTO> registerUser(@NotNull RegisterUserDTO registerUserDTO) {

        if(userRepository.existsByEmail(registerUserDTO.getEmail()) || userRepository.existsByUsername(registerUserDTO.getUsername())) {
            return Optional.empty();
        }

        User user = new User(
                registerUserDTO.getUsername(),
                registerUserDTO.getEmail(),
                registerUserDTO.getPassword()
        );

        userRepository.save(user);
        return Optional.of(new UserDataDTO(user));
    }
}
