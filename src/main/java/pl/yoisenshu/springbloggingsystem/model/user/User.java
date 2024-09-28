package pl.yoisenshu.springbloggingsystem.model.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "users")
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    @Length(min = 3, max = 24)
    @NotBlank(message = "Username must not be empty!")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Username can only contains letters, numbers, and underscores.")
    private String username;

    private LocalDateTime lastUsernameChangeAt = null;

    @Column(nullable = false)
    @Length(min = 1, max = 32)
    @NotBlank(message = "Nickname must not be empty!")
    private String nickname;

    private LocalDateTime lastNicknameChangeAt = null;

    @Column(nullable = false)
    private LocalDateTime joinedAt;

    @NotBlank(message = "Email must not be empty!")
    @Email(message = "Email must be valid!")
    private String email;

    private boolean emailVerified = false;

    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus = AccountStatus.INACTIVE;

    @NotBlank(message = "Password must not be empty!")
    @Length(min = 8, max = 30, message = "Password length should be between 8 and 30 characters!")
    private String password;

    @Setter
    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;

    public User(@NonNull String username, @NonNull String email, @NonNull String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    @PrePersist
    protected void onCreate() {
        joinedAt = LocalDateTime.now();
    }
}
