package pl.yoisenshu.springbloggingsystem.model.notification;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlNotificationRepository extends NotificationRepository, JpaRepository<Notification, Integer> { }
