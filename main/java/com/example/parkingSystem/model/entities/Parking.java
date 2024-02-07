package com.example.parkingSystem.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "parking")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Parking {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "location")
    private String location;

    @Column(name = "gps_lng")
    private double gpsLng;

    @Column(name = "gps_lat")
    private double gpsLat;

    @ManyToMany
    @JoinTable(
            name = "parking_user",
            joinColumns = @JoinColumn(name = "parking_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> userList;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parking_id")
    private List<ParkingUnit> parkingUnitList;
}
