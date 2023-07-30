package net.javaguides.springboot.controller;

import net.javaguides.springboot.dto.response.EventsResponse;
import net.javaguides.springboot.model.Courses;
import net.javaguides.springboot.model.Events;
import net.javaguides.springboot.service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventsController {

    @Autowired
    private EventsService eventsService;

    @GetMapping
    public ResponseEntity<List<EventsResponse>> getAllEvents(){
        return ResponseEntity.ok(eventsService.getAllEvents());
    }

    @PostMapping
    public ResponseEntity<Events> createEvent(@RequestBody Events events) {
        Events createdEvent = eventsService.saveOrUpdate(events);
        return ResponseEntity.ok(createdEvent);
    }
}