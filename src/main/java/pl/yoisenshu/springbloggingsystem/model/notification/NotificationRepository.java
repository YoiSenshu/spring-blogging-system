package pl.yoisenshu.springbloggingsystem.model.notification;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.yoisenshu.springbloggingsystem.model.user.User;

import java.util.List;
import java.util.Optional;

public interface NotificationRepository {

    boolean existsById(@NotNull Integer id);

    @NotNull Optional<Notification> findById(@NotNull Integer id);

    @NotNull Page<Notification> findAllByTarget(@NotNull Pageable pageable, @NotNull User target);

    @NotNull List<Notification> findAllByTarget(@NotNull User target);

    int countAllByTargetAndAndNotificationSeenIsFalse(@NotNull User target);

    @NotNull Page<Notification> findAllByTargetAndAndNotificationSeenIsFalse(@NotNull Pageable pageable, @NotNull User target);

    @NotNull List<Notification> findAllByTargetAndAndNotificationSeenIsFalse(@NotNull User target);

    void deleteById(@NotNull Integer id);
}
