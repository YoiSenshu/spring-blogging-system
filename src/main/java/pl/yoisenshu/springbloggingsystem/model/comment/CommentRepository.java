package pl.yoisenshu.springbloggingsystem.model.comment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;
import pl.yoisenshu.springbloggingsystem.model.post.Post;
import pl.yoisenshu.springbloggingsystem.model.user.User;

import java.util.List;
import java.util.Optional;

public interface CommentRepository {

    boolean existsById(@NonNull Integer id);

    @NonNull Optional<Comment> findById(@NonNull Integer id);

    int countAllByPost(@NonNull Post post);

    @NonNull
    Page<Comment> findAllByPost(@NonNull Pageable pageable, @NonNull Post post);

    @NonNull
    List<Comment> findAllByPost(@NonNull Post post);

    int countAllByCreationDetails_Author(@NonNull User author);

    @NonNull Page<Comment> findAllByCreationDetails_Author(@NonNull Pageable pageable, @NonNull User author);

    @NonNull List<Comment> findAllByCreationDetails_Author(@NonNull User author);
}
