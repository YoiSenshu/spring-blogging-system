package pl.yoisenshu.springbloggingsystem.model.report;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.yoisenshu.springbloggingsystem.model.user.User;

import java.time.LocalDateTime;

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
    @Column(nullable = false)
    private ReportStatus status = ReportStatus.PENDING;

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    private User sender;

    @Column(nullable = false)
    private LocalDateTime sentAt;

    @Column(nullable = false)
    private String reportReason;

    @ManyToOne
    @JoinColumn(name = "moderator_id", nullable = false)
    private User moderator;

    @Column(nullable = false)
    private LocalDateTime respondedAt;

    @Setter
    private String moderatorResponse;

    protected Report(@NotNull User sender, @NotNull String reportReason) {
        this.sender = sender;
        this.reportReason = reportReason;
    }

    @PrePersist
    protected void onCreate() {
        sentAt = LocalDateTime.now();
    }
}
