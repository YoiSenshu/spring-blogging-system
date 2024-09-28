package pl.yoisenshu.springbloggingsystem.model.follow;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlFollowRepository extends FollowRepository, JpaRepository<Follow, Integer> { }
