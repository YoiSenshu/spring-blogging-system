package pl.yoisenshu.springbloggingsystem.model.report;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ReportStatus {
    PENDING(false),
    IN_REVIEW(false),
    REJECTED(true),
    ACCEPTED(true);

    private final boolean closed;
}
