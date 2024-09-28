package pl.yoisenshu.springbloggingsystem.model.media;

import jakarta.persistence.*;
import lombok.Getter;
import pl.yoisenshu.springbloggingsystem.model.Details;

@Entity
@Table(name = "media")
@Getter
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Embedded
    private Details details;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(nullable = false)
    private String filePath;

    public enum Type {
        IMAGE,
        VIDEO,
        AUDIO
    }
}
