package com.mfqueiroga.vibee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mfqueiroga.vibee.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
