package pl.yoisenshu.springbloggingsystem.model.comment;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.yoisenshu.springbloggingsystem.model.post.Post;
import pl.yoisenshu.springbloggingsystem.model.user.User;

import java.util.List;
import java.util.Optional;

public interface CommentRepository {

    boolean existsById(@NotNull Integer id);

    @NotNull Optional<Comment> findById(@NotNull Integer id);

    int countAllByPost(@NotNull Post post);

    @NotNull
    Page<Comment> findAllByPost(@NotNull Pageable pageable, @NotNull Post post);

    @NotNull
    List<Comment> findAllByPost(@NotNull Post post);

    int countAllByCreationDetails_Author(@NotNull User author);

    @NotNull Page<Comment> findAllByCreationDetails_Author(@NotNull Pageable pageable, @NotNull User author);

    @NotNull List<Comment> findAllByCreationDetails_Author(@NotNull User author);
}
