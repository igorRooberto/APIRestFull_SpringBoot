package com.example.account.Account.repository;

import com.example.account.Account.entities.UserOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserOrderRepository extends JpaRepository<UserOrders, UUID> {
}
