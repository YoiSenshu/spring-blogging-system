package pl.yoisenshu.springbloggingsystem.model.report;

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
@Getter
@NoArgsConstructor
public class CommentReport extends Report {

    @ManyToOne
    @JoinColumn(name = "comment_id", nullable = false)
    private Comment reportedComment;

    public CommentReport(@NonNull Details details, @NonNull String reportReason, @NonNull Comment reportedComment) {
        super(details, reportReason);
        this.reportedComment = reportedComment;
    }
}
