package net.javaguides.springboot.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.javaguides.springboot.dto.response.EventsResponse;
import net.javaguides.springboot.model.Events;
import net.javaguides.springboot.model.Rooms;
import net.javaguides.springboot.model.Supervisors;
import net.javaguides.springboot.model.Typologies;
import net.javaguides.springboot.repository.EventsRepository;
import net.javaguides.springboot.service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EventsServiceImpl implements EventsService {

    @Autowired
    private EventsRepository eventsRepository;

    @Override
    public List<EventsResponse> getAllEvents() {
        Iterable<Events> eventsIterable = eventsRepository.findAll();
        return entitiesToDTO(eventsIterable);
    }

    private List<EventsResponse> entitiesToDTO(Iterable<Events> eventsIterable) {
        List<EventsResponse> eventsResponseList = new ArrayList<>();
        for (Events events : eventsIterable) {
            EventsResponse response = new EventsResponse();
            response.setDate(events.getDate().toString());
            response.setName(events.getName());
            response.setDescription(events.getDescription());

            response.setStartTime(events.getStartTime() != null ? events.getStartTime().toString() : null);
            response.setEndTime(events.getEndTime() != null ? events.getEndTime().toString() : null);
            response.setTypologyId(getIdFromTypologies(events.getTypologies()));
            response.setSupervisorId(getIdFromSupervisors(events.getSupervisors()));
            response.setRoomId(getIdFromRooms(events.getRooms()));

            eventsResponseList.add(response);
        }
        return eventsResponseList;
    }

    private Long getIdFromTypologies(Typologies typologies) {
        return typologies != null ? typologies.getId() : null;
    }

    private Long getIdFromSupervisors(Supervisors supervisors) {
        return supervisors != null ? supervisors.getId() : null;
    }

    private Long getIdFromRooms(Rooms rooms) {
        return rooms != null ? rooms.getId() : null;
    }

    @Override
    public Events saveOrUpdate(Events event) {
        return eventsRepository.save(event);
    }
}
