package pl.yoisenshu.springbloggingsystem.model.comment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;
import pl.yoisenshu.springbloggingsystem.model.user.User;

import java.util.List;
import java.util.Optional;

public interface ReplyRepository {

    boolean existsById(@NonNull Integer id);

    @NonNull Optional<Reply> findById(@NonNull Integer id);

    int countAllByComment(@NonNull Comment comment);

    @NonNull
    Page<Reply> findAllByComment(@NonNull Pageable pageable, @NonNull Comment comment);

    @NonNull
    List<Reply> findAllByComment(@NonNull Comment comment);

    int countAllByCreationDetails_Author(@NonNull User author);

    @NonNull Page<Reply> findAllByCreationDetails_Author(@NonNull Pageable pageable, @NonNull User author);

    @NonNull List<Reply> findAllByCreationDetails_Author(@NonNull User author);
}
