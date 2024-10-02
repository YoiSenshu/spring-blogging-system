package pl.yoisenshu.springbloggingsystem.model.report;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.yoisenshu.springbloggingsystem.model.comment.Comment;
import pl.yoisenshu.springbloggingsystem.model.user.User;

@Entity
@DiscriminatorValue("COMMENT")
@Getter
@NoArgsConstructor
public class CommentReport extends Report {

    @ManyToOne
    @JoinColumn(name = "comment_id", nullable = false)
    private Comment reportedComment;

    public CommentReport(@NotNull User user, @NotNull String reportReason, @NotNull Comment reportedComment) {
        super(user, reportReason);
        this.reportedComment = reportedComment;
    }
}
