package pl.yoisenshu.springbloggingsystem.model.like;

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
@NoArgsConstructor
@Getter
public class ReplyLike extends Like {

    @ManyToOne
    @JoinColumn(name = "reply_id", nullable = false)
    private Reply reply;

    public ReplyLike(@NonNull Details details, @NonNull Reply reply) {
        super(details);
        this.reply = reply;
    }
}
