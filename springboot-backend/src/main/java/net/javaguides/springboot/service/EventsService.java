package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;

import net.javaguides.springboot.dto.request.EventsRequest;
import net.javaguides.springboot.dto.response.EventsResponse;
import net.javaguides.springboot.dto.response.GroupsResponse;
import net.javaguides.springboot.model.Events;
import org.springframework.stereotype.Service;

@Service
public interface EventsService {

    public List<EventsResponse> getAllEvents();

    Optional<EventsResponse> getEventById(Long idEvent);

    Events saveOrUpdate(EventsRequest eventsRequest);

    void deleteEvent(Long idEvent);
}