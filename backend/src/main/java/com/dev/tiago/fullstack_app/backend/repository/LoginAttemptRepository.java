package com.dev.tiago.fullstack_app.backend.repository;

import com.dev.tiago.fullstack_app.backend.entity.LoginAttempt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginAttemptRepository extends JpaRepository<LoginAttempt, Long> {
}
