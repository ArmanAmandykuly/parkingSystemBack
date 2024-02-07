package com.example.parkingSystem.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Data
@AllArgsConstructor
public class UserDTO {
    private String name;

    private String password;

    private String contacts;
}
