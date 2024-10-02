package pl.yoisenshu.springbloggingsystem.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class ConfirmEmailDTO {

    private String username;
    private UUID token;
}
