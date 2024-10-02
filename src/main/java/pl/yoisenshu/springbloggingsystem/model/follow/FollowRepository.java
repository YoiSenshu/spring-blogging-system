package pl.yoisenshu.springbloggingsystem.model.follow;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.yoisenshu.springbloggingsystem.model.blog.Blog;
import pl.yoisenshu.springbloggingsystem.model.user.User;

import java.util.List;

public interface FollowRepository {

    @NotNull Page<Follow> findAllByFollowedBlog(@NotNull Pageable pageable, @NotNull Blog followedBlog);

    @NotNull List<Follow> findAllByFollowedBlog(@NotNull Blog followedBlog);

    @NotNull int countAllByFollowedBlog(@NotNull Blog followedBlog);

    @NotNull Page<Follow> findByFollower(@NotNull Pageable pageable, @NotNull User followingUser);

    @NotNull List<Follow> findByFollower(@NotNull User followingUser);

    @NotNull int countAllByFollower(@NotNull User followingUser);

    boolean existsByFollowedBlogAndFollower(@NotNull Blog followedBlog, @NotNull User follower);
}
