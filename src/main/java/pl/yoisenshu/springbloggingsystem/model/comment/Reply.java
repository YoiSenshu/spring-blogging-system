package pl.yoisenshu.springbloggingsystem.model.comment;

import jakarta.persistence.*;
import lombok.Getter;
import pl.yoisenshu.springbloggingsystem.model.Editable;
import pl.yoisenshu.springbloggingsystem.model.Details;

import java.time.LocalDateTime;

@Entity
@Table(name = "replies")
@Getter
public class Reply implements Editable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @Embedded
    private Details details;

    private LocalDateTime lastEditedAt = null;

    private String content;

    @Override
    public LocalDateTime getLastEditedAt() {
        return lastEditedAt;
    }
}
