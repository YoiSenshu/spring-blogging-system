package pl.yoisenshu.springbloggingsystem.model.blog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlBlogRepository extends BlogRepository, JpaRepository<Blog, Integer> { }
