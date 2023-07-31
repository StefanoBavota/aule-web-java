package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Rooms;
import net.javaguides.springboot.model.Supervisors;
import net.javaguides.springboot.service.RoomsService;
import net.javaguides.springboot.service.SupervisorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/supervisors")
public class SupervisorsController {

    @Autowired
    private SupervisorsService supervisorsService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Supervisors>> supervisorById(@PathVariable Long id) {
        return ResponseEntity.ok(supervisorsService.getSupervisorById(id));
    }
}
