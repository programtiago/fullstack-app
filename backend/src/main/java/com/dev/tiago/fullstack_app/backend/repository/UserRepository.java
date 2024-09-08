package com.dev.tiago.fullstack_app.backend.repository;

import com.dev.tiago.fullstack_app.backend.entity.User;
import com.dev.tiago.fullstack_app.backend.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findFirstByEmail(String email);
    Optional<User> findByUserRole(UserRole userRole);
}
