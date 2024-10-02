package pl.yoisenshu.springbloggingsystem.model.comment;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.yoisenshu.springbloggingsystem.model.Editable;
import pl.yoisenshu.springbloggingsystem.model.CreationDetails;
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
    @Column(nullable = false)
    private CreationDetails creationDetails;

    @Setter
    private LocalDateTime lastEditedAt = null;

    @Setter
    @Column(nullable = false)
    @NotBlank(message = "Content must not be empty!")
    private String content;

    public Comment(@NotNull Post post, @NotNull CreationDetails creationDetails, @NotNull String content) {
        this.post = post;
        this.creationDetails = creationDetails;
        this.content = content;
    }

    @Override
    public LocalDateTime getLastEditedAt() {
        return lastEditedAt;
    }
}
