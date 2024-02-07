package com.example.parkingSystem.controllers;

import com.example.parkingSystem.dto.ParkingUnitDTO;
import com.example.parkingSystem.model.entities.Parking;
import com.example.parkingSystem.model.entities.ParkingUnit;
import com.example.parkingSystem.services.ParkingService;
import com.example.parkingSystem.services.ParkingUnitService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("parkingUnits")
public class ParkingUnitController {
    private final ParkingUnitService parkingUnitService;

    private final ParkingService parkingService;

    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<String> register(@RequestBody ParkingUnitDTO dto) throws Exception {
        ParkingUnit parkingUnit = modelMapper.map(dto, ParkingUnit.class);
        Parking parking = parkingService.getById(dto.getParkingId());

        parkingUnit.setParking(parking);

        parkingUnitService.save(parkingUnit);

        return ResponseEntity.ok("OK");
    }
}
