package com.example.parkingSystem.model.repositories;

import com.example.parkingSystem.model.entities.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RequestRepository extends JpaRepository<Request, Long> {
    Optional<Request> findFirstByLocation(String location);
}