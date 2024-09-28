package pl.yoisenshu.springbloggingsystem.model.media;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;
import pl.yoisenshu.springbloggingsystem.model.user.User;

import java.util.List;
import java.util.Optional;

public interface MediaRepository {

    boolean existsById(@NonNull Integer id);

    @NonNull Optional<Media> findById(@NonNull Integer id);

    int countAllByCreationDetails_Author(@NonNull User user);

    @NonNull Page<Media> findAllByCreationDetails_Author(@NonNull Pageable pageable, @NonNull User user);

    @NonNull List<Media> findAllByCreationDetails_Author(@NonNull User user);
}
