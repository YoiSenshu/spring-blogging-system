package pl.yoisenshu.springbloggingsystem.model.media;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.yoisenshu.springbloggingsystem.model.CreationDetails;

@Entity
@Table(name = "media")
@Getter
@NoArgsConstructor
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Embedded
    @Column(nullable = false)
    private CreationDetails creationDetails;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(nullable = false)
    private String filePath;

    public Media(@NotNull CreationDetails creationDetails, @NotNull Type type, @NotNull String filePath) {
        this.creationDetails = creationDetails;
        this.type = type;
        this.filePath = filePath;
    }

    public enum Type {
        IMAGE,
        VIDEO,
        AUDIO
    }
}
