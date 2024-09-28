package pl.yoisenshu.springbloggingsystem.model.like;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import pl.yoisenshu.springbloggingsystem.model.Details;
import pl.yoisenshu.springbloggingsystem.model.comment.Comment;

@Entity
@DiscriminatorValue("COMMENT")
@NoArgsConstructor
@Getter
public class CommentLike extends Like {

    @ManyToOne
    @JoinColumn(name = "comment_id", nullable = false)
    private Comment comment;

    public CommentLike(@NonNull Details details, @NonNull Comment comment) {
        super(details);
        this.comment = comment;
    }
}
