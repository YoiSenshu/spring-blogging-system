package pl.yoisenshu.springbloggingsystem.model.notification;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;
import pl.yoisenshu.springbloggingsystem.model.user.User;

import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
@NoArgsConstructor
@Getter
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User target;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @NotBlank(message = "Content must not be empty!")
    @Column(nullable = false)
    private String content;

    private String onClick = null;

    @Setter
    boolean notificationSeen = false;

    public Notification(@NotNull User target, @NotNull String content, @Nullable String onClick) {
        this.target = target;
        this.content = content;
        this.onClick = onClick;
    }

    public Notification(@NotNull User target, @NotNull String content) {
        this.target = target;
        this.content = content;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
