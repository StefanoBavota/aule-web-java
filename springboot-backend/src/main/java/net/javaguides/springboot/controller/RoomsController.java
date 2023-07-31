package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Rooms;
import net.javaguides.springboot.service.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/rooms")
public class RoomsController {

    @Autowired
    private RoomsService roomsService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Rooms>> roomById(@PathVariable Long id) {
        return ResponseEntity.ok(roomsService.getRoomById(id));
    }
}
