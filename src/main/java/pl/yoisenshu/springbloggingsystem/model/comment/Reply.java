package pl.yoisenshu.springbloggingsystem.model.comment;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;
import pl.yoisenshu.springbloggingsystem.model.Editable;
import pl.yoisenshu.springbloggingsystem.model.Details;

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
    private Details details;

    @Setter
    private LocalDateTime lastEditedAt = null;

    @Setter
    private String content;

    public Reply(@NonNull Comment comment, @NonNull Details details, @NonNull String content) {
        this.comment = comment;
        this.details = details;
        this.content = content;
    }

    @Override
    public LocalDateTime getLastEditedAt() {
        return lastEditedAt;
    }
}
