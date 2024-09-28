package pl.yoisenshu.springbloggingsystem.model.follow;

import jakarta.persistence.*;
import lombok.Getter;
import pl.yoisenshu.springbloggingsystem.model.user.User;

@Entity
@Table(name = "follows")
@Getter
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "followed_user_id", nullable = false)
    private User followed;

    @ManyToOne
    @JoinColumn(name = "follower_user_id", nullable = false)
    private User follower;
}
