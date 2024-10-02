package pl.yoisenshu.springbloggingsystem.model.report;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.yoisenshu.springbloggingsystem.model.post.Post;
import pl.yoisenshu.springbloggingsystem.model.user.User;

@Entity
@DiscriminatorValue("POST")
@Getter
@NoArgsConstructor
public class PostReport extends Report {

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post reportedPost;

    public PostReport(@NotNull User user, @NotNull String reportReason, @NotNull Post reportedPost) {
        super(user, reportReason);
        this.reportedPost = reportedPost;
    }
}
