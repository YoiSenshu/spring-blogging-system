package pl.yoisenshu.springbloggingsystem.model.blog;

import jakarta.persistence.*;
import lombok.Getter;
import pl.yoisenshu.springbloggingsystem.model.post.Post;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "blogs")
@Getter
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String blogName;

    private String blogTitle;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<BlogAuthor> authors;

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Post> posts;
}
