package pl.yoisenshu.springbloggingsystem.model.like;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlLikeRepository<T extends Like> extends LikeRepository<T>, JpaRepository<T, Integer> { }
