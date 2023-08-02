package net.javaguides.springboot.mapper;

import net.javaguides.springboot.dto.response.EventsResponse;
import net.javaguides.springboot.model.Events;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventsMapper {

//    public List<EventsResponse> entitiesToDTOFilteredByRoomAndDate(Iterable<Events> eventsIterable, Long classId, LocalDate startOfWeek, LocalDate endOfWeek) {
//        List<EventsResponse> eventsResponseList = new ArrayList<>();
//        for (Events events : eventsIterable) {
//            if (events.getRooms() != null && events.getRooms().getId() == classId && isEventWithinWeek(events.getDate(), startOfWeek, endOfWeek)) {
//                EventsResponse response = mapEventToResponse(events);
//                response.setCourse(getCoursesForEvent(events));
//                eventsResponseList.add(response);
//            }
//        }
//        return eventsResponseList;
//    }
//
//    public boolean isEventWithinWeek(LocalDate eventDate, LocalDate startOfWeek, LocalDate endOfWeek) {
//        return !eventDate.isBefore(startOfWeek) && !eventDate.isAfter(endOfWeek);
//    }

}
