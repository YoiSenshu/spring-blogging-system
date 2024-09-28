package pl.yoisenshu.springbloggingsystem.model.media;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import pl.yoisenshu.springbloggingsystem.model.Details;

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
    private Details details;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(nullable = false)
    private String filePath;

    public Media(@NonNull Details details, @NonNull Type type, @NonNull String filePath) {
        this.details = details;
        this.type = type;
        this.filePath = filePath;
    }

    public enum Type {
        IMAGE,
        VIDEO,
        AUDIO
    }
}
