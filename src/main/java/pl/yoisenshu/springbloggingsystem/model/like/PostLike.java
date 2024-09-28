package pl.yoisenshu.springbloggingsystem.model.like;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import pl.yoisenshu.springbloggingsystem.model.Details;
import pl.yoisenshu.springbloggingsystem.model.post.Post;

@Entity
@DiscriminatorValue("POST")
@NoArgsConstructor
@Getter
public class PostLike extends Like {

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post; // Odniesienie do posta

    public PostLike(@NonNull Details details, @NonNull Post post) {
        super(details);
        this.post = post;
    }
}
