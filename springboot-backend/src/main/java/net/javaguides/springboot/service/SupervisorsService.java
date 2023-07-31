package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Rooms;
import net.javaguides.springboot.model.Supervisors;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface SupervisorsService {

    public List<Supervisors> getAllSupervisors();

    Supervisors saveOrUpdate(Supervisors supervisor);

    Optional<Supervisors> getSupervisorById(Long idSupervisor);

    void deleteSupervisor(Long idSupervisor);

}
