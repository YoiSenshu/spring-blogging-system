package pl.yoisenshu.springbloggingsystem.model.report;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.yoisenshu.springbloggingsystem.model.user.User;

import java.util.List;
import java.util.Optional;

public interface ReportRepository<T extends Report> {

    boolean existsById(@NotNull Integer id);

    @NotNull Optional<T> findById(@NotNull Integer id);

    @NotNull Page<T> findBySender(@NotNull Pageable pageable, @NotNull User sender);

    @NotNull List<T> findBySender(@NotNull User sender);

    @NotNull Page<T> findAllByStatus(@NotNull Pageable pageable, @NotNull ReportStatus status);

    @NotNull List<T> findAllByStatus(@NotNull ReportStatus status);
}
