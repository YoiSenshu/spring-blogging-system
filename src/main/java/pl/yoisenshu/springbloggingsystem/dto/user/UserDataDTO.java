package pl.yoisenshu.springbloggingsystem.dto.user;

import jakarta.validation.constraints.NotNull;
import pl.yoisenshu.springbloggingsystem.model.user.User;

public class UserDataDTO {

    public UserDataDTO(@NotNull User user) {
    }
}
