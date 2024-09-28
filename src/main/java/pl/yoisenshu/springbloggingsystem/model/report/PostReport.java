package pl.yoisenshu.springbloggingsystem.model.report;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import pl.yoisenshu.springbloggingsystem.model.Details;
import pl.yoisenshu.springbloggingsystem.model.post.Post;

@Entity
@DiscriminatorValue("POST")
@Getter
@NoArgsConstructor
public class PostReport extends Report {

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post reportedPost;

    public PostReport(@NonNull Details details, @NonNull String reportReason, @NonNull Post reportedPost) {
        super(details, reportReason);
        this.reportedPost = reportedPost;
    }
}
