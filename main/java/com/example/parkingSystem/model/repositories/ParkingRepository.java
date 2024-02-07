package com.example.parkingSystem.model.repositories;

import com.example.parkingSystem.model.entities.Parking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingRepository extends JpaRepository<Parking, Long> {
}
