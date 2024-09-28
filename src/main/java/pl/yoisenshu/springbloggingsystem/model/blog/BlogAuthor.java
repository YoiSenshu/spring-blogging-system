package pl.yoisenshu.springbloggingsystem.model.blog;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import pl.yoisenshu.springbloggingsystem.model.user.User;

@Entity
@Table(name = "blog_authors")
@Getter
@NoArgsConstructor
public class BlogAuthor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private boolean ownerOfBlog;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "blog_id", nullable = false)
    private Blog blog;

    public BlogAuthor(@NonNull User user, @NonNull Blog blog, boolean ownerOfBlog) {
        this.ownerOfBlog = ownerOfBlog;
        this.user = user;
        this.blog = blog;
    }
}
