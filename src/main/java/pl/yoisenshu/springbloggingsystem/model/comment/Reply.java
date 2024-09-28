package pl.yoisenshu.springbloggingsystem.model.comment;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;
import pl.yoisenshu.springbloggingsystem.model.Editable;
import pl.yoisenshu.springbloggingsystem.model.CreationDetails;

import java.time.LocalDateTime;

@Entity
@Table(name = "replies")
@Getter
@NoArgsConstructor
public class Reply implements Editable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @Embedded
    @Column(nullable = false)
    private CreationDetails creationDetails;

    @Setter
    private LocalDateTime lastEditedAt = null;

    @Setter
    @Column(nullable = false)
    @NotBlank(message = "Content must not be empty!")
    private String content;

    public Reply(@NonNull Comment comment, @NonNull CreationDetails creationDetails, @NonNull String content) {
        this.comment = comment;
        this.creationDetails = creationDetails;
        this.content = content;
    }

    @Override
    public LocalDateTime getLastEditedAt() {
        return lastEditedAt;
    }
}
