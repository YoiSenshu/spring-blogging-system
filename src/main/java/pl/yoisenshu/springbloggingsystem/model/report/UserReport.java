package pl.yoisenshu.springbloggingsystem.model.report;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.yoisenshu.springbloggingsystem.model.user.User;

@Entity
@DiscriminatorValue("USER")
@Getter
@NoArgsConstructor
public class UserReport extends Report {

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User reportedUser;

    public UserReport(@NotNull User user, @NotNull String reportReason, @NotNull User reportedUser) {
        super(user, reportReason);
        this.reportedUser = reportedUser;
    }
}
