package com.abhi.webservices.myrestwebservice.controller;

import com.abhi.webservices.myrestwebservice.dao.VehicleDAO;
import com.abhi.webservices.myrestwebservice.exception.VehicleNotFoundException;
import com.abhi.webservices.myrestwebservice.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class VehicleResource {

    @Autowired
    private VehicleDAO vehicleDAO;

    @GetMapping("/vehicles")
    public List<Vehicle> getAllVehicles(){
        return vehicleDAO.findAll();
    }

    @GetMapping("/vehicles/{id}")
    public Resource<Vehicle> retrieveVehicle(@PathVariable final long id){
        Resource<Vehicle> vehicleResource = new Resource<>(vehicleDAO.findById(id).orElseThrow(() -> new VehicleNotFoundException("ID -"+ id)));
        vehicleResource.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getAllVehicles()).withRel("All-Vehicles"));
        return vehicleResource;
    }

    @DeleteMapping("/vehicles/{id}")
    public void removeVehicle(@PathVariable final long id){
         vehicleDAO.deleteById(id);
    }

    @PostMapping("/vehicles")
    public ResponseEntity<Vehicle> saveVehicle(@Valid @RequestBody final Vehicle vehicle){
        Vehicle savedVehicle = vehicleDAO.save(vehicle);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedVehicle.getId()).toUri();

        return ResponseEntity.created(uri).body(savedVehicle);
    }
}
