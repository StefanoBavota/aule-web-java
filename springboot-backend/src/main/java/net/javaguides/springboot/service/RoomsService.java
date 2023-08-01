package net.javaguides.springboot.service;

import net.javaguides.springboot.dto.response.RoomsResponse;
import net.javaguides.springboot.model.Rooms;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface RoomsService {

    public List<RoomsResponse> getAllRooms();

    Rooms saveOrUpdate(Rooms room);

    Optional<RoomsResponse> getRoomById(Long idRoom);

    void deleteRoom(Long idRoom);
}
