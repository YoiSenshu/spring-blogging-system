package pl.yoisenshu.springbloggingsystem.model.like;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import pl.yoisenshu.springbloggingsystem.model.CreationDetails;
import pl.yoisenshu.springbloggingsystem.model.post.Post;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "post_likes")
public class PostLike extends Like {

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    public PostLike(@NonNull CreationDetails creationDetails, @NonNull Post post) {
        super(creationDetails);
        this.post = post;
    }
}
