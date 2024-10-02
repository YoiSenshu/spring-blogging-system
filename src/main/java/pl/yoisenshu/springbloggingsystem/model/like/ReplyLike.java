package pl.yoisenshu.springbloggingsystem.model.like;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.yoisenshu.springbloggingsystem.model.CreationDetails;
import pl.yoisenshu.springbloggingsystem.model.comment.Reply;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "reply_likes")
public class ReplyLike extends Like {

    @ManyToOne
    @JoinColumn(name = "reply_id", nullable = false)
    private Reply reply;

    public ReplyLike(@NotNull CreationDetails creationDetails, @NotNull Reply reply) {
        super(creationDetails);
        this.reply = reply;
    }
}
