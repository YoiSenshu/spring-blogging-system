package pl.yoisenshu.springbloggingsystem.model.blog;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import pl.yoisenshu.springbloggingsystem.model.user.User;

import java.util.List;
import java.util.Optional;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

    boolean existsById(@NonNull Integer id);

    @NonNull Optional<Blog> findById(@NonNull Integer id);

    @NonNull List<Blog> findAll();

    @NonNull Page<Blog> findAll(@NonNull Pageable pageable);

    boolean existsByBlogName(@NonNull String blogName);

    @NonNull Optional<Blog> findByBlogName(@NonNull String blogName);

    @Query("SELECT b FROM Blog b WHERE b.blogName LIKE %:startingBlogNamePart% OR b.blogName = :startingBlogNamePart")
    @NonNull Page<Blog> findByBlogNameStartingWith(@NonNull Pageable pageable, @NonNull String startingBlogNamePart);

    @Query("SELECT b FROM Blog b WHERE b.blogTitle LIKE %:startingTitlePart% OR b.blogTitle = :startingTitlePart")
    @NonNull Page<Blog> findByBlogTitleStartingWith(@NonNull Pageable pageable, @NonNull String startingTitlePart);

    @Query("SELECT b FROM Blog b WHERE b.blogName LIKE %:name% OR b.blogTitle LIKE %:name% OR b.blogName = :name OR b.blogTitle = :name")
    @NonNull Page<Blog> findByBlogNameOrTitle(@NonNull Pageable pageable, @NonNull String name);

    @Query("SELECT b FROM Blog b JOIN b.authors a WHERE a.user = :user")
    @NonNull List<Blog> findByAuthors_User(@NonNull User user);
}
