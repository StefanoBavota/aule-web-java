package net.javaguides.springboot.service.impl;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import net.javaguides.springboot.dto.request.EventsRequest;
import net.javaguides.springboot.dto.response.EventsResponse;
import net.javaguides.springboot.model.*;
import net.javaguides.springboot.repository.EventsRepository;
import net.javaguides.springboot.repository.RoomsRepository;
import net.javaguides.springboot.repository.SupervisorsRepository;
import net.javaguides.springboot.repository.TypologiesRepository;
import net.javaguides.springboot.service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EventsServiceImpl implements EventsService {

    @Autowired
    private EventsRepository eventsRepository;

    @Autowired
    private TypologiesRepository typologiesRepository;

    @Autowired
    private SupervisorsRepository supervisorsRepository;

    @Autowired
    private RoomsRepository roomsRepository;

    @Override
    public List<EventsResponse> getAllEvents() {
        Iterable<Events> eventsIterable = eventsRepository.findAll();
        return entitiesToDTO(eventsIterable);
    }

    private List<EventsResponse> entitiesToDTO(Iterable<Events> eventsIterable) {
        List<EventsResponse> eventsResponseList = new ArrayList<>();
        for (Events events : eventsIterable) {
            EventsResponse response = mapEventToResponse(events);
            List<Courses> coursesForEvent = getCoursesForEvent(events);
            response.setCourse(coursesForEvent);

            if (!coursesForEvent.isEmpty()) {
                eventsResponseList.add(response);
            }
        }
        return eventsResponseList;
    }

    private EventsResponse mapEventToResponse(Events events) {
        EventsResponse response = new EventsResponse();
        response.setId(events.getId());
        response.setDate(events.getDate().toString());
        response.setName(events.getName());
        response.setDescription(events.getDescription());

        response.setStartTime(events.getStartTime() != null ? events.getStartTime().toString() : null);
        response.setEndTime(events.getEndTime() != null ? events.getEndTime().toString() : null);
        response.setTypologyId(getIdFromTypologies(events.getTypologies()));
        response.setSupervisorId(getIdFromSupervisors(events.getSupervisors()));
        response.setRoomId(getIdFromRooms(events.getRooms()));

        response.setTypology(events.getTypologies());
        response.setSupervisor(events.getSupervisors());
        response.setRoom(events.getRooms());

        return response;
    }

    private List<Courses> getCoursesForEvent(Events events) {
        List<Courses> coursesForEvent = new ArrayList<>();
        List<CourseEvent> courseEvents = events.getCourseEvent();
        for (CourseEvent courseEvent : courseEvents) {
            Courses course = courseEvent.getCourses();
            if (course != null) {
                coursesForEvent.add(course);
            }
        }
        return coursesForEvent;
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
    public Events saveOrUpdate(EventsRequest eventsRequest) {
        return eventsRepository.save(this.DTOUpdateEntity(eventsRequest));
    }

    private Events DTOUpdateEntity(EventsRequest eventsRequest) {
        Events event = new Events();

        event.setDate(Date.valueOf(eventsRequest.getDate()));
        event.setStartTime(Time.valueOf(eventsRequest.getStartTime()));
        event.setEndTime(Time.valueOf(eventsRequest.getEndTime()));
        event.setName(eventsRequest.getName());
        event.setDescription(eventsRequest.getDescription());
        event.setRooms(eventsRequest.getRoom());
        event.setSupervisors(eventsRequest.getSupervisor());
        event.setTypologies(eventsRequest.getTypology());

        return event;
    }
}
