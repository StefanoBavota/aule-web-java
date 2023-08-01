package net.javaguides.springboot.controller;

import net.javaguides.springboot.dto.response.LocationsResponse;
import net.javaguides.springboot.model.Locations;
import net.javaguides.springboot.model.Typologies;
import net.javaguides.springboot.service.LocationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/locations")
public class LocationsController {

    @Autowired
    private LocationsService locationsService;

    @GetMapping
    public ResponseEntity<List<LocationsResponse>> getAllTypologies(){
        return ResponseEntity.ok(locationsService.getAllLocations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<LocationsResponse>> getLocationById(@PathVariable Long id) {
        return ResponseEntity.ok(locationsService.getLocationById(id));
    }
}
