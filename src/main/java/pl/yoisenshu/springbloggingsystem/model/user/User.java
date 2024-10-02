package pl.yoisenshu.springbloggingsystem.model.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import pl.yoisenshu.springbloggingsystem.model.follow.Follow;
import pl.yoisenshu.springbloggingsystem.model.like.Like;
import pl.yoisenshu.springbloggingsystem.model.post.Post;
import pl.yoisenshu.springbloggingsystem.model.report.Report;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Table(name = "users")
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Setter
    @Column(unique = true, nullable = false)
    @Length(min = 3, max = 24)
    @NotBlank(message = "Username must not be empty!")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Username can only contains letters, numbers, and underscores.")
    private String username;

    @Setter
    private LocalDateTime lastUsernameChangeAt = null;

    @Setter
    @Column(nullable = false)
    @Length(min = 1, max = 32)
    @NotBlank(message = "Nickname must not be empty!")
    private String nickname;

    @Setter
    private LocalDateTime lastNicknameChangeAt = null;

    @Column(nullable = false)
    private LocalDateTime joinedAt;

    @Setter
    @NotBlank(message = "Email must not be empty!")
    @Email(message = "Email must be valid!")
    private String email;

    @Setter
    private boolean emailVerified = false;

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountStatus accountStatus = AccountStatus.INACTIVE;

    @Setter
    @NotBlank(message = "Password must not be empty!")
    @Length(min = 8, max = 30, message = "Password length should be between 8 and 30 characters!")
    private String password;

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role = Role.USER;


    @OneToMany(mappedBy = "creationDetails.author", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Post> posts;

    @OneToMany(mappedBy = "follower", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Follow> follows;

    @OneToMany(mappedBy = "creationDetails.author", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Like> likes;

    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Report> reports;



    public User(@NotNull String username, @NotNull String email, @NotNull String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    @PrePersist
    protected void onCreate() {
        joinedAt = LocalDateTime.now();
    }
}
