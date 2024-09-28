package pl.yoisenshu.springbloggingsystem.model.media;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
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

    public Media(@NonNull CreationDetails creationDetails, @NonNull Type type, @NonNull String filePath) {
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
