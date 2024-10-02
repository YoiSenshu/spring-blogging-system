package pl.yoisenshu.springbloggingsystem.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import pl.yoisenshu.springbloggingsystem.dto.user.ConfirmEmailDTO;
import pl.yoisenshu.springbloggingsystem.dto.user.RegisterUserDTO;
import pl.yoisenshu.springbloggingsystem.dto.user.RegisteredUserDTO;
import pl.yoisenshu.springbloggingsystem.model.user.AccountStatus;
import pl.yoisenshu.springbloggingsystem.model.user.User;
import pl.yoisenshu.springbloggingsystem.model.user.UserRepository;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    public void registerUser_successfulRegistration() {

        RegisterUserDTO registerUserDTO = new RegisterUserDTO("test_user", "test@example.com", "password");
        when(userRepository.existsByEmail(registerUserDTO.getEmail())).thenReturn(false);
        when(userRepository.existsByUsername(registerUserDTO.getUsername())).thenReturn(false);

        RegisteredUserDTO result = userService.registerUser(registerUserDTO);

        assertEquals(registerUserDTO.getUsername(), result.getUsername());
        assertEquals(registerUserDTO.getEmail(), result.getEmail());
    }

    @Test
    public void registerUser_duplicatedEmail_throwsIllegalArgumentException() {

        RegisterUserDTO registerUserDTO = new RegisterUserDTO("test_user", "duplicate@example.com", "password");
        when(userRepository.existsByEmail(anyString())).thenReturn(true);

        assertThrows(IllegalArgumentException.class, () -> userService.registerUser(registerUserDTO));
    }

    @Test
    public void registerUser_duplicatedUsername_throwsIllegalArgumentException() {

        RegisterUserDTO registerUserDTO = new RegisterUserDTO("duplicate_user", "test@example.com", "password");
        when(userRepository.existsByUsername(anyString())).thenReturn(true);

        assertThrows(IllegalArgumentException.class, () -> userService.registerUser(registerUserDTO));
    }

    @Test
    public void confirmEmail_successful() {

        UUID emailVerificationToken = UUID.randomUUID();
        ConfirmEmailDTO confirmEmailDTO = new ConfirmEmailDTO("test_user", emailVerificationToken);
        User user = new User("test_user", "test@example.com", "password");
        user.setEmailVerificationToken(emailVerificationToken);
        when(userRepository.findByUsername(confirmEmailDTO.getUsername())).thenReturn(Optional.of(user));

        RegisteredUserDTO result = userService.confirmEmail(confirmEmailDTO);

        assertTrue(result.isEmailVerified());
        assertEquals(AccountStatus.ACTIVE, result.getAccountStatus());
    }

    @Test
    public void confirmEmail_incorrectToken_throwsIllegalArgumentException() {

        UUID emailVerificationToken = UUID.randomUUID();
        ConfirmEmailDTO confirmEmailDTO = new ConfirmEmailDTO("test_user", emailVerificationToken);
        User user = new User("test_user", "test@example.com", "password");
        user.setEmailVerificationToken(UUID.randomUUID());
        when(userRepository.findByUsername(confirmEmailDTO.getUsername())).thenReturn(Optional.of(user));

        assertThrows(IllegalArgumentException.class, () -> userService.confirmEmail(confirmEmailDTO));
    }

    @Test
    public void confirmEmail_notExistingUsername_throwsIllegalArgumentException() {

        UUID emailVerificationToken = UUID.randomUUID();
        ConfirmEmailDTO confirmEmailDTO = new ConfirmEmailDTO("test_user", emailVerificationToken);
        User user = new User("test_user", "test@example.com", "password");
        user.setEmailVerificationToken(emailVerificationToken);
        when(userRepository.findByUsername(confirmEmailDTO.getUsername())).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> userService.confirmEmail(confirmEmailDTO));
    }
}