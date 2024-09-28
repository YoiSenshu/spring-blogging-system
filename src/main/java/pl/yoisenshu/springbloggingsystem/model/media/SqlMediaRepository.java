package pl.yoisenshu.springbloggingsystem.model.media;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlMediaRepository extends MediaRepository, JpaRepository<Media, Integer> { }
