package pl.yoisenshu.springbloggingsystem.model.notification;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import pl.yoisenshu.springbloggingsystem.model.Details;

@Entity
@Table(name = "notifications")
@NoArgsConstructor
@Getter
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Embedded
    @Column(nullable = false)
    private Details details;

    @NotBlank(message = "Content must not be empty!")
    @Column(nullable = false)
    private String content;

    private String onClick = null;

    @Setter
    boolean notificationSeen = false;

    public Notification(@NonNull Details details, @NonNull String content, @Nullable String onClick) {
        this.details = details;
        this.content = content;
        this.onClick = onClick;
    }

    public Notification(@NonNull Details details, @NonNull String content) {
        this.details = details;
        this.content = content;
    }
}
