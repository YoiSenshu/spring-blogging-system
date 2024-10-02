package pl.yoisenshu.springbloggingsystem.model.like;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.yoisenshu.springbloggingsystem.model.CreationDetails;
import pl.yoisenshu.springbloggingsystem.model.comment.Comment;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "comment_likes")
public class CommentLike extends Like {

    @ManyToOne
    @JoinColumn(name = "comment_id", nullable = false)
    private Comment comment;

    public CommentLike(@NotNull CreationDetails creationDetails, @NotNull Comment comment) {
        super(creationDetails);
        this.comment = comment;
    }
}
