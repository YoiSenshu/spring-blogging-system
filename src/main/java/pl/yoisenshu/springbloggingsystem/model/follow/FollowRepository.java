package pl.yoisenshu.springbloggingsystem.model.follow;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;
import pl.yoisenshu.springbloggingsystem.model.user.User;

public interface FollowRepository {

    @NonNull
    Page<Follow> findByFollowed(@NonNull User followedUser, @NonNull Pageable pageable);

    @NonNull int countAllByFollowed(@NonNull User followedUser);

    @NonNull Page<Follow> findByFollower(@NonNull User followingUser, @NonNull Pageable pageable);

    @NonNull int countAllByFollower(@NonNull User followingUser);

    boolean existsByFollowedAndFollower(@NonNull User followed, @NonNull User follower);
}
