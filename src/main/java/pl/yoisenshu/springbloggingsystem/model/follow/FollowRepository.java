package pl.yoisenshu.springbloggingsystem.model.follow;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;
import pl.yoisenshu.springbloggingsystem.model.blog.Blog;
import pl.yoisenshu.springbloggingsystem.model.user.User;

import java.util.List;

public interface FollowRepository {

    @NonNull Page<Follow> findAllByFollowedBlog(@NonNull Pageable pageable, @NonNull Blog followedBlog);

    @NonNull List<Follow> findAllByFollowedBlog(@NonNull Blog followedBlog);

    @NonNull int countAllByFollowedBlog(@NonNull Blog followedBlog);

    @NonNull Page<Follow> findByFollower(@NonNull Pageable pageable, @NonNull User followingUser);

    @NonNull List<Follow> findByFollower(@NonNull User followingUser);

    @NonNull int countAllByFollower(@NonNull User followingUser);

    boolean existsByFollowedBlogAndFollower(@NonNull Blog followedBlog, @NonNull User follower);
}
