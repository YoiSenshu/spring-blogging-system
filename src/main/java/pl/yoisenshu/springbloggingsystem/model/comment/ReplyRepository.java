package pl.yoisenshu.springbloggingsystem.model.comment;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.yoisenshu.springbloggingsystem.model.user.User;

import java.util.List;
import java.util.Optional;

public interface ReplyRepository {

    boolean existsById(@NotNull Integer id);

    @NotNull Optional<Reply> findById(@NotNull Integer id);

    int countAllByComment(@NotNull Comment comment);

    @NotNull
    Page<Reply> findAllByComment(@NotNull Pageable pageable, @NotNull Comment comment);

    @NotNull
    List<Reply> findAllByComment(@NotNull Comment comment);

    int countAllByCreationDetails_Author(@NotNull User author);

    @NotNull Page<Reply> findAllByCreationDetails_Author(@NotNull Pageable pageable, @NotNull User author);

    @NotNull List<Reply> findAllByCreationDetails_Author(@NotNull User author);
}
