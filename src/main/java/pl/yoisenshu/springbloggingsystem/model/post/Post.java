package pl.yoisenshu.springbloggingsystem.model.post;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;
import pl.yoisenshu.springbloggingsystem.model.Editable;
import pl.yoisenshu.springbloggingsystem.model.Details;
import pl.yoisenshu.springbloggingsystem.model.blog.Blog;

import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
@Getter
@NoArgsConstructor
public class Post implements Editable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "blog_id", nullable = false)
    private Blog blog;

    @Embedded
    @Column(nullable = false)
    private Details details;

    @Setter
    @Column(nullable = false)
    private String content;

    @Setter
    private LocalDateTime lastEditedAt = null;

    public Post(@NonNull Blog blog, @NonNull Details details, @NonNull String content) {
        this.blog = blog;
        this.details = details;
        this.content = content;
    }

    @Override
    public LocalDateTime getLastEditedAt() {
        return lastEditedAt;
    }
}
