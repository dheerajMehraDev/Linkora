package com.dheeraj.user_service.Repository;

import com.dheeraj.user_service.Entity.User;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(@Email(message = "email should be valid") String email);
}
