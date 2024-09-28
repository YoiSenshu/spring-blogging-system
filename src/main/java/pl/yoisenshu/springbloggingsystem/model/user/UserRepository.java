package pl.yoisenshu.springbloggingsystem.model.user;

import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    boolean existsById(@NonNull Integer id);

    @NonNull
    Optional<User> findById(@NonNull Integer id);

    boolean existsByUsername(@NonNull String username);

    @NonNull Optional<User> findByUsername(@NonNull String username);

    boolean existsByEmail(@NonNull String email);

    @NonNull Optional<User> findByEmail(@NonNull String email);

    @NonNull
    List<User> findAllByNicknameStartingWith(@NonNull String nicknameStartPart);

    @NonNull User save(@NonNull User user);
}
