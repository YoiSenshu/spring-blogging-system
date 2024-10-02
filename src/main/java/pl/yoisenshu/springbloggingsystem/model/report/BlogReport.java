package pl.yoisenshu.springbloggingsystem.model.report;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.yoisenshu.springbloggingsystem.model.blog.Blog;
import pl.yoisenshu.springbloggingsystem.model.user.User;

@Entity
@DiscriminatorValue("BLOG")
@Getter
@NoArgsConstructor
public class BlogReport extends Report {

    @ManyToOne
    @JoinColumn(name = "blog_id", nullable = false)
    private Blog reportedBlog;

    public BlogReport(@NotNull User sender, @NotNull String reportReason, @NotNull Blog reportedBlog) {
        super(sender, reportReason);
        this.reportedBlog = reportedBlog;
    }
}
