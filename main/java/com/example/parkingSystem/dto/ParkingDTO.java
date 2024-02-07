package com.example.parkingSystem.dto;

import com.example.parkingSystem.model.entities.ParkingUnit;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ParkingDTO {
    private String location;

    private double gpsLng;

    private double gpsLat;

    private List<ParkingUnitDTO> parkingUnitList;
}
