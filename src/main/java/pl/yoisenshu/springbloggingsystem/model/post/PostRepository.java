package pl.yoisenshu.springbloggingsystem.model.post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;
import pl.yoisenshu.springbloggingsystem.model.blog.Blog;
import pl.yoisenshu.springbloggingsystem.model.user.User;

import java.util.List;
import java.util.Optional;

public interface PostRepository {

    boolean existsById(@NonNull Integer id);

    @NonNull
    Optional<Post> findById(@NonNull Integer id);

    int countAllByBlog(@NonNull Blog blog);

    @NonNull
    Page<Post> findAllByBlog(@NonNull Pageable pageable, @NonNull Blog blog);

    @NonNull
    List<Post> findAllByBlog(@NonNull Blog blog);

    int countAllByCreationDetails_Author(@NonNull User author);

    @NonNull Page<Post> findAllByCreationDetails_Author(@NonNull Pageable pageable, @NonNull User author);

    @NonNull List<Post> findAllByCreationDetails_Author(@NonNull User author);
}
