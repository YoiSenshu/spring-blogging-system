package pl.yoisenshu.springbloggingsystem.model.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlPostRepository extends PostRepository, JpaRepository<Post, Integer> { }
