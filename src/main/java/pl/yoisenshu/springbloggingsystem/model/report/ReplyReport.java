package pl.yoisenshu.springbloggingsystem.model.report;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.yoisenshu.springbloggingsystem.model.comment.Reply;
import pl.yoisenshu.springbloggingsystem.model.user.User;

@Entity
@DiscriminatorValue("REPLY")
@Getter
@NoArgsConstructor
public class ReplyReport extends Report {

    @ManyToOne
    @JoinColumn(name = "reply_id", nullable = false)
    private Reply reportedReply;

    public ReplyReport(@NotNull User user, @NotNull String reportReason, @NotNull Reply reportedReply) {
        super(user, reportReason);
        this.reportedReply = reportedReply;
    }
}
