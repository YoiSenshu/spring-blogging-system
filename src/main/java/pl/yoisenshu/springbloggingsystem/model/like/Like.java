package pl.yoisenshu.springbloggingsystem.model.like;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import pl.yoisenshu.springbloggingsystem.model.CreationDetails;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "likes")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Embedded
    @Column(nullable = false)
    private CreationDetails creationDetails;

    public Like(@NonNull CreationDetails creationDetails) {
        this.creationDetails = creationDetails;
    }
}
