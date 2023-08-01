package net.javaguides.springboot.controller;

import net.javaguides.springboot.dto.request.EventsRequest;
import net.javaguides.springboot.dto.request.GroupsRequest;
import net.javaguides.springboot.dto.response.EventsResponse;
import net.javaguides.springboot.dto.response.GroupsResponse;
import net.javaguides.springboot.model.Events;
import net.javaguides.springboot.model.Groups;
import net.javaguides.springboot.service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/events")
public class EventsController {

    @Autowired
    private EventsService eventsService;

    @GetMapping
    public ResponseEntity<List<EventsResponse>> getAllEvents(){
        return ResponseEntity.ok(eventsService.getAllEvents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<EventsResponse>> groupById(@PathVariable Long id) {
        return ResponseEntity.ok(eventsService.getEventById(id));
    }

//    @RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    @PostMapping
    public ResponseEntity<Events> createEvent(@RequestBody EventsRequest eventsRequest) {
        Events createdEvent = eventsService.saveOrUpdate(eventsRequest);
        return ResponseEntity.ok(createdEvent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Events> updateEvent(@PathVariable Long id, @RequestBody EventsRequest eventsRequest) {
        eventsRequest.setId(id);
        Events updatedEvent = eventsService.saveOrUpdate(eventsRequest);
        return ResponseEntity.ok(updatedEvent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEventById(@PathVariable Long id) {
        eventsService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }
}