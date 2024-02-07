package com.example.parkingSystem.model.repositories;

import com.example.parkingSystem.model.entities.ParkingUnit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingUnitRepository extends JpaRepository<ParkingUnit, Long> {
}
