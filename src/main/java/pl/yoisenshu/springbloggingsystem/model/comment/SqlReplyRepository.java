package pl.yoisenshu.springbloggingsystem.model.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlReplyRepository extends ReplyRepository, JpaRepository<Reply, Integer> { }
