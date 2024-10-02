package pl.yoisenshu.springbloggingsystem.model.post;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.yoisenshu.springbloggingsystem.model.blog.Blog;
import pl.yoisenshu.springbloggingsystem.model.user.User;

import java.util.List;
import java.util.Optional;

public interface PostRepository {

    boolean existsById(@NotNull Integer id);

    @NotNull
    Optional<Post> findById(@NotNull Integer id);

    int countAllByBlog(@NotNull Blog blog);

    @NotNull
    Page<Post> findAllByBlog(@NotNull Pageable pageable, @NotNull Blog blog);

    @NotNull
    List<Post> findAllByBlog(@NotNull Blog blog);

    int countAllByCreationDetails_Author(@NotNull User author);

    @NotNull Page<Post> findAllByCreationDetails_Author(@NotNull Pageable pageable, @NotNull User author);

    @NotNull List<Post> findAllByCreationDetails_Author(@NotNull User author);
}
