package com.example.registration_system.repository;
import com.example.registration_system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>
{
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
}