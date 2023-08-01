package net.javaguides.springboot.service.impl;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import net.javaguides.springboot.dto.request.EventsRequest;
import net.javaguides.springboot.dto.request.RoomsRequest;
import net.javaguides.springboot.dto.response.EventsResponse;
import net.javaguides.springboot.dto.response.RoomsResponse;
import net.javaguides.springboot.model.*;
import net.javaguides.springboot.repository.GroupsRepository;
import net.javaguides.springboot.repository.LocationsRepository;
import net.javaguides.springboot.repository.RoomsRepository;
import net.javaguides.springboot.repository.SupervisorsRepository;
import net.javaguides.springboot.service.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RoomServiceImpl implements RoomsService {

    @Autowired
    private RoomsRepository roomsRepository;

    @Autowired
    private LocationsRepository locationsRepository;

    @Autowired
    private SupervisorsRepository supervisorsRepository;

    @Autowired
    private GroupsRepository groupsRepository;

    //------------- GET ALL -------------
    @Override
    public List<RoomsResponse> getAllRooms() {
        Iterable<Rooms> roomsIterable = roomsRepository.findAll();
        return entitiesToDTO(roomsIterable);
    }

    //------------- GET BY ID -------------
    @Override
    public Optional<RoomsResponse> getRoomById(Long id) {
        Optional<Rooms> room = roomsRepository.findById(id);

        return room.map(this::mapRoomToResponse);
    }

    private List<RoomsResponse> entitiesToDTO(Iterable<Rooms> roomsIterable) {
        List<RoomsResponse> roomsResponseList = new ArrayList<>();
        for (Rooms rooms : roomsIterable) {
            RoomsResponse response = mapRoomToResponse(rooms);

            roomsResponseList.add(response);
        }
        return roomsResponseList;
    }

    private RoomsResponse mapRoomToResponse(Rooms rooms) {
        RoomsResponse response = new RoomsResponse();
        response.setId(rooms.getId());
        response.setName(rooms.getName());
        response.setCapacity(rooms.getCapacity());
        response.setDescription(rooms.getDescription());
        response.setElectricalOutlets(rooms.getElectrical_outlets());
        response.setEthernetPorts(rooms.getEthernet_ports());
        response.setLink(rooms.getLink());

        response.setLocationId(getIdFromLocations(rooms.getLocations()));
        response.setSupervisorId(getIdFromSupervisors(rooms.getSupervisors()));
        response.setGroupId(getIdFromGroups(rooms.getGroups()));

        return response;
    }

    private Long getIdFromLocations(Locations locations) {
        return locations != null ? locations.getId() : null;
    }

    private Long getIdFromSupervisors(Supervisors supervisors) {
        return supervisors != null ? supervisors.getId() : null;
    }

    private Long getIdFromGroups(Groups groups) {
        return groups != null ? groups.getId() : null;
    }

    //------------- POST AND PUT -------------
    @Override
    public Long saveOrUpdate(RoomsRequest roomsRequest) {
        Optional<Locations> location = locationsRepository.findById(roomsRequest.getLocation_id());
        Optional<Supervisors> supervisor = supervisorsRepository.findById(roomsRequest.getSupervisor_id());
        Optional<Groups> group = groupsRepository.findById(roomsRequest.getGroup_id());

        Rooms room = DTOUpdateEntity(roomsRequest, location, supervisor, group);

        return room.getId();
    }

    private Rooms DTOUpdateEntity(RoomsRequest roomsRequest, Optional<Locations> location, Optional<Supervisors> supervisor, Optional<Groups> group) {
        Rooms room;
        if (roomsRequest.getId() != null) {
            Optional<Rooms> existingEvent = roomsRepository.findById(roomsRequest.getId());
            room = existingEvent.orElse(new Rooms());
        } else {
            room = new Rooms();
        }

        room.setName(roomsRequest.getName());
        room.setCapacity(roomsRequest.getCapacity());
        room.setDescription(roomsRequest.getDescription());
        room.setElectrical_outlets(roomsRequest.getElectricalOutlets());
        room.setEthernet_ports(roomsRequest.getEthernetPorts());
        room.setLink(roomsRequest.getLink());

        room.setLocations(location.orElse(null));
        room.setSupervisors(supervisor.orElse(null));
        room.setGroups(group.orElse(null));

        return roomsRepository.save(room);
    }

    //------------- DELETE -------------
    @Override
    public void deleteRoom(Long id) {
        roomsRepository.deleteById(id);
    }
}