package pl.yoisenshu.springbloggingsystem.model.report;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import pl.yoisenshu.springbloggingsystem.model.Details;
import pl.yoisenshu.springbloggingsystem.model.user.User;

@Entity
@DiscriminatorValue("USER")
@Getter
@NoArgsConstructor
public class UserReport extends Report {

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User reportedUser;

    public UserReport(@NonNull Details details, @NonNull String reportReason, @NonNull User reportedUser) {
        super(details, reportReason);
        this.reportedUser = reportedUser;
    }
}
