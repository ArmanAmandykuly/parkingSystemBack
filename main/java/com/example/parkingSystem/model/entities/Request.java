package com.example.parkingSystem.model.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "requests")
@Data
public class Request {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "location")
    private String location;

    @Column(name = "number")
    private int number;

    @Column(name = "book")
    private boolean book;
}
