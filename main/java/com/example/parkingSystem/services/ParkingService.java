package com.example.parkingSystem.services;

import com.example.parkingSystem.dto.ParkingDTO;
import com.example.parkingSystem.model.entities.Parking;
import com.example.parkingSystem.model.repositories.ParkingRepository;
import com.example.parkingSystem.utils.exceptions.ParkingNotFoundException;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Data
public class ParkingService {
    private final ParkingRepository parkingRepository;

    @Transactional
    public void save(Parking parking) {
        parkingRepository.save(parking);
    }

    public Parking getById(long parkingId) throws Exception{
        Optional<Parking> parkingOptional = parkingRepository.findById(parkingId);

        if(parkingOptional.isEmpty()) {
            throw new ParkingNotFoundException();
        }

        return parkingOptional.get();
    }

    public List<Parking> getAll() {
        return parkingRepository.findAll();
    }
}
