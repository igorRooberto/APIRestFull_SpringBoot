package com.example.UserEndereco.Local.repository;

import com.example.UserEndereco.Local.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
