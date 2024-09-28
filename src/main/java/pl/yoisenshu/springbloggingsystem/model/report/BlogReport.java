package pl.yoisenshu.springbloggingsystem.model.report;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import pl.yoisenshu.springbloggingsystem.model.Details;
import pl.yoisenshu.springbloggingsystem.model.blog.Blog;

@Entity
@DiscriminatorValue("BLOG")
@Getter
@NoArgsConstructor
public class BlogReport extends Report {

    @ManyToOne
    @JoinColumn(name = "blog_id", nullable = false)
    private Blog reportedBlog;

    public BlogReport(@NonNull Details details, @NonNull String reportReason, @NonNull Blog reportedBlog) {
        super(details, reportReason);
        this.reportedBlog = reportedBlog;
    }
}
