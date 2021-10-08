package com.jenkins.SpringbootwithJenkins.Controller;

import com.jenkins.SpringbootwithJenkins.Entity.Ride;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.jenkins.SpringbootwithJenkins.repository.RideRepo;

import javax.validation.Valid;

@RestController
@Slf4j
public class RideController {

    private final RideRepo rideRepo;
    public RideController(RideRepo rideRepo) {
        this.rideRepo = rideRepo;
    }

    @GetMapping(value = "/rides", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Ride> getRides(){
        return rideRepo.findAll();
    }

    @GetMapping(value = "ride/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Ride getRidebyId(@PathVariable long id) {
        return rideRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Invalid ride id %s", id)));
    }

    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Ride createRide(@RequestBody @Valid Ride ride){
        return rideRepo.save(ride);
    }
}
