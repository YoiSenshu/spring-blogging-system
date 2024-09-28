package pl.yoisenshu.springbloggingsystem.model.like;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;
import pl.yoisenshu.springbloggingsystem.model.comment.Comment;
import pl.yoisenshu.springbloggingsystem.model.comment.Reply;
import pl.yoisenshu.springbloggingsystem.model.post.Post;
import pl.yoisenshu.springbloggingsystem.model.user.User;

import java.util.List;
import java.util.Optional;

/* TODO:
* Add counting methods.
* */

public interface LikeRepository<T extends Like> {

    boolean existsById(@NonNull Integer id);

    @NonNull Optional<T> findById(@NonNull Integer id);

    @NonNull
    Page<Like> findAllByCreationDetails_Author(
            @NonNull Pageable pageable,
            @NonNull User user);

    @NonNull
    List<Like> findAllByCreationDetails_Author(@NonNull User user);

    int countAllByCreationDetails_Author(@NonNull User user);



    /*boolean existsByPostAndCreationDetails_Author(
            @NonNull Post post,
            @NonNull User user);*/

    @NonNull Page<PostLike> findAllByPostAndCreationDetails_Author(
            @NonNull Pageable pageable,
            @NonNull Post post,
            @NonNull User user);

    @NonNull List<PostLike> findAllByPostAndCreationDetails_Author(
            @NonNull Post post,
            @NonNull User user);



    /*boolean existsByCommentAndCreationDetails_Author(
            @NonNull Comment comment,
            @NonNull User user);*/

    @NonNull Page<CommentLike> findAllByCommentAndCreationDetails_Author(
            @NonNull Pageable pageable,
            @NonNull Comment comment,
            @NonNull User user);

    @NonNull List<CommentLike> findAllByCommentAndCreationDetails_Author(
            @NonNull Comment comment,
            @NonNull User user);



    /*boolean existsByReplyAndCreationDetails_Author(
            @NonNull Reply reply,
            @NonNull User user);*/

    @NonNull Page<ReplyLike> findAllByReplyAndCreationDetails_Author(
            @NonNull Pageable pageable,
            @NonNull Reply reply,
            @NonNull User user);

    @NonNull List<ReplyLike> findAllByReplyAndCreationDetails_Author(
            @NonNull Reply reply,
            @NonNull User user);

    void deleteById(@NonNull Integer id);
}
