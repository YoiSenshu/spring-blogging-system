package pl.yoisenshu.springbloggingsystem.model;

import org.springframework.lang.Nullable;

import java.time.LocalDateTime;

public interface Editable {

    default boolean isEdited() {
        return getLastEditedAt() != null;
    }

    @Nullable LocalDateTime getLastEditedAt();
}
