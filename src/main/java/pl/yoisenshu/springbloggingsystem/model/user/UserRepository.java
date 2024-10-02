package pl.yoisenshu.springbloggingsystem.model.user;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    boolean existsById(@NotNull Integer id);

    @NotNull Optional<User> findById(@NotNull Integer id);

    boolean existsByUsername(@NotNull String username);

    @NotNull Optional<User> findByUsername(@NotNull String username);

    boolean existsByEmail(@NotNull String email);

    @NotNull Optional<User> findByEmail(@NotNull String email);

    @NotNull Page<User> findAllByNicknameStartingWith(@NotNull Pageable pageable, @NotNull String nicknameStartPart);

    @NotNull List<User> findAllByNicknameStartingWith(@NotNull String nicknameStartPart);

    @NotNull User save(@NotNull User user);
}
