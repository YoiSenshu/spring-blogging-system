package pl.yoisenshu.springbloggingsystem.model.like;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import pl.yoisenshu.springbloggingsystem.model.Details;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "likes")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "like_type")
public abstract class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Embedded
    private Details details;

    public Like(@NonNull Details details) {
        this.details = details;
    }
}
