package com.example.parkingSystem.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "parking_unit")
@AllArgsConstructor
@NoArgsConstructor
public class ParkingUnit {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "number")
    private int number;

    @Column(name = "is_booked")
    private boolean isBooked;

    @ManyToOne
    private Parking parking;
}
