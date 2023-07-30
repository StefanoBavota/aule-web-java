package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.dto.response.EventsResponse;
import net.javaguides.springboot.model.Events;
import org.springframework.stereotype.Service;

@Service
public interface EventsService {

    public List<EventsResponse> getAllEvents();

    Events saveOrUpdate(Events event);

}