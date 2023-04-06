package com.example.app.repositories;

import com.example.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findClientByPhoneNumber(String phoneNumber);
}
