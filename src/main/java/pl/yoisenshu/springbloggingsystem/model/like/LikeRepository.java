package pl.yoisenshu.springbloggingsystem.model.like;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    boolean existsById(@NotNull Integer id);

    @NotNull Optional<T> findById(@NotNull Integer id);

    @NotNull
    Page<Like> findAllByCreationDetails_Author(
            @NotNull Pageable pageable,
            @NotNull User user);

    @NotNull
    List<Like> findAllByCreationDetails_Author(@NotNull User user);

    int countAllByCreationDetails_Author(@NotNull User user);



    /*boolean existsByPostAndCreationDetails_Author(
            @NotNull Post post,
            @NotNull User user);*/

    @NotNull Page<PostLike> findAllByPostAndCreationDetails_Author(
            @NotNull Pageable pageable,
            @NotNull Post post,
            @NotNull User user);

    @NotNull List<PostLike> findAllByPostAndCreationDetails_Author(
            @NotNull Post post,
            @NotNull User user);



    /*boolean existsByCommentAndCreationDetails_Author(
            @NotNull Comment comment,
            @NotNull User user);*/

    @NotNull Page<CommentLike> findAllByCommentAndCreationDetails_Author(
            @NotNull Pageable pageable,
            @NotNull Comment comment,
            @NotNull User user);

    @NotNull List<CommentLike> findAllByCommentAndCreationDetails_Author(
            @NotNull Comment comment,
            @NotNull User user);



    /*boolean existsByReplyAndCreationDetails_Author(
            @NotNull Reply reply,
            @NotNull User user);*/

    @NotNull Page<ReplyLike> findAllByReplyAndCreationDetails_Author(
            @NotNull Pageable pageable,
            @NotNull Reply reply,
            @NotNull User user);

    @NotNull List<ReplyLike> findAllByReplyAndCreationDetails_Author(
            @NotNull Reply reply,
            @NotNull User user);

    void deleteById(@NotNull Integer id);
}
