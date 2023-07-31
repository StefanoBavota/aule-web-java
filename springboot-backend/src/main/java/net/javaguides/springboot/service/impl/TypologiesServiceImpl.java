package net.javaguides.springboot.service.impl;

import jakarta.transaction.Transactional;
import net.javaguides.springboot.model.Typologies;
import net.javaguides.springboot.repository.RoomsRepository;
import net.javaguides.springboot.repository.TypologiesRepository;
import net.javaguides.springboot.service.TypologiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TypologiesServiceImpl implements TypologiesService {

    @Autowired
    private TypologiesRepository typologiesRepository;

    @Override
    public List<Typologies> getAllTypologies() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Typologies saveOrUpdate(Typologies typology) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<Typologies> getTypologyById(Long id) {
        return typologiesRepository.findById(id);
    }

    @Override
    public void deleteTypology(Long idTypology) {
        // TODO Auto-generated method stub
    }
}
