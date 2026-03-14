package com.busticket.busticket_bookingsystem.repository;

import com.busticket.busticket_bookingsystem.entity.entityUser.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepo extends JpaRepository<Notification, Long> {

}
