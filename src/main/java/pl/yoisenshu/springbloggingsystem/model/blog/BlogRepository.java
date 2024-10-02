package pl.yoisenshu.springbloggingsystem.model.blog;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.yoisenshu.springbloggingsystem.model.user.User;

import java.util.List;
import java.util.Optional;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

    boolean existsById(@NotNull Integer id);

    @NotNull Optional<Blog> findById(@NotNull Integer id);

    @NotNull List<Blog> findAll();

    @NotNull Page<Blog> findAll(@NotNull Pageable pageable);

    boolean existsByBlogName(@NotNull String blogName);

    @NotNull Optional<Blog> findByBlogName(@NotNull String blogName);

    @Query("SELECT b FROM Blog b WHERE b.blogName LIKE %:startingBlogNamePart% OR b.blogName = :startingBlogNamePart")
    @NotNull Page<Blog> findByBlogNameStartingWith(@NotNull Pageable pageable, @NotNull String startingBlogNamePart);

    @Query("SELECT b FROM Blog b WHERE b.blogTitle LIKE %:startingTitlePart% OR b.blogTitle = :startingTitlePart")
    @NotNull Page<Blog> findByBlogTitleStartingWith(@NotNull Pageable pageable, @NotNull String startingTitlePart);

    @Query("SELECT b FROM Blog b WHERE b.blogName LIKE %:name% OR b.blogTitle LIKE %:name% OR b.blogName = :name OR b.blogTitle = :name")
    @NotNull Page<Blog> findByBlogNameOrTitle(@NotNull Pageable pageable, @NotNull String name);

    @Query("SELECT b FROM Blog b JOIN b.authors a WHERE a.user = :user")
    @NotNull List<Blog> findByAuthors_User(@NotNull User user);
}
