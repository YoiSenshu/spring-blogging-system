package pl.yoisenshu.springbloggingsystem.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import pl.yoisenshu.springbloggingsystem.model.user.User;

import java.time.LocalDateTime;

@Embeddable
@Getter
@NoArgsConstructor
public class Details {

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User author;

    private LocalDateTime publicationDate;

    public Details(@NonNull User author, @NonNull LocalDateTime publicationDate) {
        this.author = author;
        this.publicationDate = publicationDate;
    }
}
