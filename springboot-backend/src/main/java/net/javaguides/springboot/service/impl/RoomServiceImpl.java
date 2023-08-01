package net.javaguides.springboot.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import net.javaguides.springboot.dto.response.EventsResponse;
import net.javaguides.springboot.dto.response.RoomsResponse;
import net.javaguides.springboot.model.Courses;
import net.javaguides.springboot.model.Events;
import net.javaguides.springboot.model.Rooms;
import net.javaguides.springboot.repository.RoomsRepository;
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

        return response;
    }

    //------------- POST AND PUT -------------
    @Override
    public Rooms saveOrUpdate(Rooms room) {
        return roomsRepository.save(room);
    }

    //------------- DELETE -------------
    @Override
    public void deleteRoom(Long id) {
        roomsRepository.deleteById(id);
    }
}