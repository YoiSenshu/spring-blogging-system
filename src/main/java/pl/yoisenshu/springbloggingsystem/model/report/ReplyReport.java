package pl.yoisenshu.springbloggingsystem.model.report;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import pl.yoisenshu.springbloggingsystem.model.Details;
import pl.yoisenshu.springbloggingsystem.model.comment.Reply;

@Entity
@DiscriminatorValue("REPLY")
@Getter
@NoArgsConstructor
public class ReplyReport extends Report {

    @ManyToOne
    @JoinColumn(name = "reply_id", nullable = false)
    private Reply reportedReply;

    public ReplyReport(@NonNull Details details, @NonNull String reportReason, @NonNull Reply reportedReply) {
        super(details, reportReason);
        this.reportedReply = reportedReply;
    }
}
