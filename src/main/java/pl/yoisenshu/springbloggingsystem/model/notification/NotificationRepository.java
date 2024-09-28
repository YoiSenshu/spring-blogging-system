package pl.yoisenshu.springbloggingsystem.model.notification;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;
import pl.yoisenshu.springbloggingsystem.model.user.User;

import java.util.List;
import java.util.Optional;

public interface NotificationRepository {

    boolean existsById(@NonNull Integer id);

    @NonNull Optional<Notification> findById(@NonNull Integer id);

    @NonNull Page<Notification> findAllByTarget(@NonNull Pageable pageable, @NonNull User target);

    @NonNull List<Notification> findAllByTarget(@NonNull User target);

    int countAllByTargetAndAndNotificationSeenIsFalse(@NonNull User target);

    @NonNull Page<Notification> findAllByTargetAndAndNotificationSeenIsFalse(@NonNull Pageable pageable, @NonNull User target);

    @NonNull List<Notification> findAllByTargetAndAndNotificationSeenIsFalse(@NonNull User target);

    void deleteById(@NonNull Integer id);
}
