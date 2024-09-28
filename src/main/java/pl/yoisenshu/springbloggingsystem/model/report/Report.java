package pl.yoisenshu.springbloggingsystem.model.report;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import pl.yoisenshu.springbloggingsystem.model.Details;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "report_type", discriminatorType = DiscriminatorType.STRING)
@NoArgsConstructor
@Getter
public abstract class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private ReportStatus status = ReportStatus.PENDING;

    @Embedded
    @Column(nullable = false)
    private Details reportSenderDetails;

    private String reportReason;

    @Embedded
    private Details moderatorDetails;

    private String moderatorResponse;

    protected Report(@NonNull Details reportSenderDetails, @NonNull String reportReason) {
        this.reportSenderDetails = reportSenderDetails;
        this.reportReason = reportReason;
    }
}
