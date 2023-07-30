package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Supervisors;

import java.util.List;

public interface SupervisorsService {

    public List<Supervisors> getAllSupervisors();

    Supervisors saveOrUpdate(Supervisors supervisor);

    Supervisors getSupervisorById(Long idSupervisor);

    void deleteSupervisor(Long idSupervisor);

}
