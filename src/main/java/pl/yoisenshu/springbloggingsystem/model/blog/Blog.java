package pl.yoisenshu.springbloggingsystem.model.blog;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.NonNull;
import pl.yoisenshu.springbloggingsystem.model.post.Post;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "blogs")
@Getter
@NoArgsConstructor
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Setter
    @Column(unique = true, nullable = false)
    @Length(min = 3, max = 24)
    @NotBlank(message = "Blog name must not be empty!")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Blog name can only contains letters, numbers, and underscores.")
    private String blogName;

    @Setter
    private LocalDateTime lastBlogNameChangeAt = null;

    @Setter
    @Column(nullable = false)
    @Length(min = 1, max = 32)
    @NotBlank(message = "Title must not be empty!")
    private String blogTitle;

    @Setter
    private LocalDateTime lastBlogTitleChangeAt = null;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<BlogAuthor> authors;

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Post> posts;

    public Blog(@NonNull String blogName, @NonNull String blogTitle) {
        this.blogName = blogName;
        this.blogTitle = blogTitle;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
