package com.example.mandelnyamsite.repos;

import com.example.mandelnyamsite.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
