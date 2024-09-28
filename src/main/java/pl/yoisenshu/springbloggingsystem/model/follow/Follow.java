package pl.yoisenshu.springbloggingsystem.model.follow;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import pl.yoisenshu.springbloggingsystem.model.user.User;

@Entity
@Table(name = "follows")
@Getter
@NoArgsConstructor
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "followed_id", nullable = false)
    private User followed;

    @ManyToOne
    @JoinColumn(name = "follower_id", nullable = false)
    private User follower;

    public Follow(@NonNull User followed, @NonNull User follower) {
        this.followed = followed;
        this.follower = follower;
    }
}
