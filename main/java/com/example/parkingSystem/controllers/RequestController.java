package com.example.parkingSystem.controllers;

import com.example.parkingSystem.dto.RequestDTO;
import com.example.parkingSystem.model.entities.Request;
import com.example.parkingSystem.services.RequestService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("booking")
public class RequestController {
    private final RequestService service;

    private final ModelMapper modelMapper;

    public RequestController(RequestService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<Integer> getRequest(@RequestParam(name = "location") String location) {
        Optional<Request> requestOptional = service.getRequest(location);

        Logger logger = LoggerFactory.getLogger(getClass());
        logger.info(location);

        if(requestOptional.isPresent()) {
            return ResponseEntity.ok(requestOptional.get().getNumber());
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping
    public ResponseEntity<String> postRequest(@RequestBody RequestDTO requestDTO) {

        Request request = modelMapper.map(requestDTO, Request.class);
        service.putRequest(request);

        return ResponseEntity.ok("OK");
    }
}