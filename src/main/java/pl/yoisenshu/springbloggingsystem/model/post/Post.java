package pl.yoisenshu.springbloggingsystem.model.post;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.yoisenshu.springbloggingsystem.model.Editable;
import pl.yoisenshu.springbloggingsystem.model.CreationDetails;
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
    private CreationDetails creationDetails;

    @Setter
    @Column(nullable = false)
    private String content;

    @Setter
    private LocalDateTime lastEditedAt = null;

    public Post(@NotNull Blog blog, @NotNull CreationDetails creationDetails, @NotNull String content) {
        this.blog = blog;
        this.creationDetails = creationDetails;
        this.content = content;
    }

    @Override
    public LocalDateTime getLastEditedAt() {
        return lastEditedAt;
    }
}
