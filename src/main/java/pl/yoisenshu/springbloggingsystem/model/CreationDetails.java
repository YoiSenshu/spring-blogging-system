package pl.yoisenshu.springbloggingsystem.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.yoisenshu.springbloggingsystem.model.user.User;

import java.time.LocalDateTime;

@Embeddable
@Getter
@NoArgsConstructor
public class CreationDetails {

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User author;

    private LocalDateTime publicationDate;

    public CreationDetails(@NotNull User author, @NotNull LocalDateTime publicationDate) {
        this.author = author;
        this.publicationDate = publicationDate;
    }
}
