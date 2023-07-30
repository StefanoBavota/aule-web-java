package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Typologies;

import java.util.List;

public interface TypologiesService {

    public List<Typologies> getAllTypologies();

    Typologies saveOrUpdate(Typologies typology);

    Typologies getTypologyById(Long idTypology);

    void deleteTypology(Long idTypology);
}
