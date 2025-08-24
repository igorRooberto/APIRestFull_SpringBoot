package com.example.User.UserApi.repository;

import com.example.User.UserApi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
