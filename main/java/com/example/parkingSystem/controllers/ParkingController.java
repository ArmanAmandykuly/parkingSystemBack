package com.example.parkingSystem.controllers;

import com.example.parkingSystem.dto.ParkingDTO;
import com.example.parkingSystem.dto.ParkingUnitDTO;
import com.example.parkingSystem.model.entities.Parking;
import com.example.parkingSystem.model.entities.ParkingUnit;
import com.example.parkingSystem.services.ParkingService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/parking")
@RequiredArgsConstructor
public class ParkingController {
    private final ParkingService parkingService;

    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<String> registerParking(@RequestBody ParkingDTO dto) {
        Parking parking = modelMapper.map(dto, Parking.class);

        parkingService.save(parking);

        return ResponseEntity.ok("OK");
    }

    @GetMapping
    public List<ParkingDTO> getParking() {
        List<Parking> parkings = parkingService.getAll();
        List<ParkingDTO> parkingDTOs = parkings.stream()
                .map(parking -> {
                    ParkingDTO parking1 = modelMapper.map(parking, ParkingDTO.class);
                    parking1.setParkingUnitList(parking.getParkingUnitList().stream().map(parkingUnit -> modelMapper.map(parkingUnit, ParkingUnitDTO.class)).toList());

                    return parking1;
                })
                .toList();

        return parkingDTOs;
    }

//    @PostMapping
//    public ResponseEntity<String> bookParking() {
//        return ResponseEntity.ok("OK");
//    }
}
