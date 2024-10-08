package pl.yoisenshu.springbloggingsystem.model.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlCommentRepository extends CommentRepository, JpaRepository<Comment, Integer> { }
