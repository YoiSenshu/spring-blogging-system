package pl.yoisenshu.springbloggingsystem.dto.user;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import pl.yoisenshu.springbloggingsystem.model.user.AccountStatus;
import pl.yoisenshu.springbloggingsystem.model.user.User;

@Getter
public class RegisteredUserDTO {

    private final int id;
    private final String username;
    private final String email;
    private final boolean emailVerified;
    private final AccountStatus accountStatus;

    public RegisteredUserDTO(@NotNull User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.emailVerified = user.isEmailVerified();
        this.accountStatus = user.getAccountStatus();
    }
}
