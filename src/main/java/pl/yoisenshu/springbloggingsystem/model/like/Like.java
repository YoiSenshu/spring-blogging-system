package pl.yoisenshu.springbloggingsystem.model.like;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
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

    public Like(@NotNull CreationDetails creationDetails) {
        this.creationDetails = creationDetails;
    }
}
