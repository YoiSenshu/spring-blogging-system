package pl.yoisenshu.springbloggingsystem.model.report;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
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

    public CommentReport(@NonNull User user, @NonNull String reportReason, @NonNull Comment reportedComment) {
        super(user, reportReason);
        this.reportedComment = reportedComment;
    }
}
