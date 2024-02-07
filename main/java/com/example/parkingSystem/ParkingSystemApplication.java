package com.example.parkingSystem;

import com.example.parkingSystem.dto.ParkingDTO;
import com.example.parkingSystem.dto.ParkingUnitDTO;
import com.example.parkingSystem.model.entities.Parking;
import com.example.parkingSystem.model.entities.ParkingUnit;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ParkingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingSystemApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration()
				.setMatchingStrategy(MatchingStrategies.STRICT);
		modelMapper.addMappings(new PropertyMap<Parking, ParkingDTO>() {

			@Override
			protected void configure() {
				skip().setParkingUnitList(null);
			}
		});

		return modelMapper;
	}
}