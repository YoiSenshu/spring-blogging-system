package pl.yoisenshu.springbloggingsystem.model.media;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.yoisenshu.springbloggingsystem.model.user.User;

import java.util.List;
import java.util.Optional;

public interface MediaRepository {

    boolean existsById(@NotNull Integer id);

    @NotNull Optional<Media> findById(@NotNull Integer id);

    int countAllByCreationDetails_Author(@NotNull User user);

    @NotNull Page<Media> findAllByCreationDetails_Author(@NotNull Pageable pageable, @NotNull User user);

    @NotNull List<Media> findAllByCreationDetails_Author(@NotNull User user);
}
