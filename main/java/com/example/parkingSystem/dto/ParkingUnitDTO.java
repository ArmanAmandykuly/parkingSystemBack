package com.example.parkingSystem.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ParkingUnitDTO {
    private int number;

    private long parkingId;

    private boolean isBooked;
}
