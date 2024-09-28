package pl.yoisenshu.springbloggingsystem.model.post;

import jakarta.persistence.*;
import lombok.Getter;
import pl.yoisenshu.springbloggingsystem.model.Editable;
import pl.yoisenshu.springbloggingsystem.model.Details;
import pl.yoisenshu.springbloggingsystem.model.blog.Blog;

import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
@Getter
public class Post implements Editable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "blog_id", nullable = false)
    private Blog blog;

    @Embedded
    private Details details;

    private String content;

    private LocalDateTime lastEditedAt = null;

    @Override
    public LocalDateTime getLastEditedAt() {
        return lastEditedAt;
    }
}
