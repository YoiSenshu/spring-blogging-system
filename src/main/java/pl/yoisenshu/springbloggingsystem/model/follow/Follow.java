package pl.yoisenshu.springbloggingsystem.model.follow;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.yoisenshu.springbloggingsystem.model.blog.Blog;
import pl.yoisenshu.springbloggingsystem.model.user.User;

@Entity
@Table(name = "follows")
@Getter
@NoArgsConstructor
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "blog_id", nullable = false)
    private Blog followedBlog;

    @ManyToOne
    @JoinColumn(name = "follower_id", nullable = false)
    private User follower;

    public Follow(@NotNull Blog followedBlog, @NotNull User follower) {
        this.followedBlog = followedBlog;
        this.follower = follower;
    }
}
