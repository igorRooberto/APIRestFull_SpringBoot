package com.example.UserEndereco.Local.repository;

import com.example.UserEndereco.Local.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
