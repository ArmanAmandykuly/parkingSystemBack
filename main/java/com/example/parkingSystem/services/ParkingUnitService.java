package com.example.parkingSystem.services;

import com.example.parkingSystem.dto.ParkingUnitDTO;
import com.example.parkingSystem.model.entities.Parking;
import com.example.parkingSystem.model.entities.ParkingUnit;
import com.example.parkingSystem.model.repositories.ParkingRepository;
import com.example.parkingSystem.model.repositories.ParkingUnitRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ParkingUnitService {
    private final ParkingUnitRepository parkingUnitRepository;

    private final ParkingRepository parkingRepository;

    @Transactional
    public void save(ParkingUnit parkingUnit) {
        parkingUnitRepository.save(parkingUnit);
    }
}
