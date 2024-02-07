package com.example.parkingSystem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class RequestDTO {
    @JsonProperty("location")
    private String location;

    @JsonProperty("number")
    private int number;

    @JsonProperty("book")
    private boolean book;
}
