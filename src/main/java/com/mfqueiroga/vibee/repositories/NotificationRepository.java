package com.mfqueiroga.vibee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mfqueiroga.vibee.entities.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
