package net.javaguides.springboot.controller;

import net.javaguides.springboot.dto.response.RoomsResponse;
import net.javaguides.springboot.model.Rooms;
import net.javaguides.springboot.service.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rooms")
public class RoomsController {

    @Autowired
    private RoomsService roomsService;

    @GetMapping
    public ResponseEntity<List<RoomsResponse>> getAllRooms(){
        return ResponseEntity.ok(roomsService.getAllRooms());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<RoomsResponse>> roomById(@PathVariable Long id) {
        return ResponseEntity.ok(roomsService.getRoomById(id));
    }

    @PostMapping
    public ResponseEntity<Rooms> createRoom(@RequestBody Rooms rooms) {
        Rooms createdRoom = roomsService.saveOrUpdate(rooms);
        return ResponseEntity.ok(createdRoom);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rooms> updateRoom(@PathVariable Long id, @RequestBody Rooms rooms) {
        rooms.setId(id);
        Rooms updatedRoom = roomsService.saveOrUpdate(rooms);
        return ResponseEntity.ok(updatedRoom);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoomById(@PathVariable Long id) {
        roomsService.deleteRoom(id);
        return ResponseEntity.noContent().build();
    }
}
