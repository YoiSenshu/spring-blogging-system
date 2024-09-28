package pl.yoisenshu.springbloggingsystem.model.comment;

import jakarta.persistence.*;
import lombok.Getter;
import pl.yoisenshu.springbloggingsystem.model.Editable;
import pl.yoisenshu.springbloggingsystem.model.Details;
import pl.yoisenshu.springbloggingsystem.model.post.Post;

import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
@Getter
public class Comment implements Editable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @Embedded
    private Details details;

    private LocalDateTime lastEditedAt = null;

    private String content;

    @Override
    public LocalDateTime getLastEditedAt() {
        return lastEditedAt;
    }
}
