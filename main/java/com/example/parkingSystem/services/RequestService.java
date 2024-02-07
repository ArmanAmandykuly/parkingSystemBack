package com.example.parkingSystem.services;

import com.example.parkingSystem.model.entities.Request;
import com.example.parkingSystem.model.repositories.RequestRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RequestService {
    private final RequestRepository repository;

    public RequestService(RequestRepository repository) {
        this.repository = repository;
    }

    public Optional<Request> getRequest(String location) {
        return repository.findFirstByLocation(location);
    }

    public void putRequest(Request request) {
        repository.save(request);
    }
}
