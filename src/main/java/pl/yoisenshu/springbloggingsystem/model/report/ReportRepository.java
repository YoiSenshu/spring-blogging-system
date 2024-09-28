package pl.yoisenshu.springbloggingsystem.model.report;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;
import pl.yoisenshu.springbloggingsystem.model.user.User;

import java.util.List;
import java.util.Optional;

public interface ReportRepository<T extends Report> {

    boolean existsById(@NonNull Integer id);

    @NonNull Optional<T> findById(@NonNull Integer id);

    @NonNull Page<T> findBySender(@NonNull Pageable pageable, @NonNull User sender);

    @NonNull List<T> findBySender(@NonNull User sender);

    @NonNull Page<T> findAllByStatus(@NonNull Pageable pageable, @NonNull ReportStatus status);

    @NonNull List<T> findAllByStatus(@NonNull ReportStatus status);
}
