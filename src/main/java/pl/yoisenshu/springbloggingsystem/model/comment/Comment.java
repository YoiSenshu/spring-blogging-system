package pl.yoisenshu.springbloggingsystem.model.comment;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;
import pl.yoisenshu.springbloggingsystem.model.Editable;
import pl.yoisenshu.springbloggingsystem.model.Details;
import pl.yoisenshu.springbloggingsystem.model.post.Post;

import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
@Getter
@NoArgsConstructor
public class Comment implements Editable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @Embedded
    private Details details;

    @Setter
    private LocalDateTime lastEditedAt = null;

    @Setter
    private String content;

    public Comment(@NonNull Post post, @NonNull Details details, @NonNull String content) {
        this.post = post;
        this.details = details;
        this.content = content;
    }

    @Override
    public LocalDateTime getLastEditedAt() {
        return lastEditedAt;
    }
}
