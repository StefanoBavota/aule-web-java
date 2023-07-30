package net.javaguides.springboot.service.impl;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Rooms> getAllRooms() {
        return (List<Rooms>) roomsRepository.findAll();
    }

    @Override
    public Optional<Rooms> getRoomById(Long id) {
        return roomsRepository.findById(id);
    }

    @Override
    public Rooms saveOrUpdate(Rooms room) {
        System.out.println("Contenuto della stanza: " + room);
        return roomsRepository.save(room);
    }

    @Override
    public void deleteRoom(Long id) {
        roomsRepository.deleteById(id);
    }
}