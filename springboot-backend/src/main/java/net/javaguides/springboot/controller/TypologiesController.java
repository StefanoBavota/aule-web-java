package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Supervisors;
import net.javaguides.springboot.model.Typologies;
import net.javaguides.springboot.service.SupervisorsService;
import net.javaguides.springboot.service.TypologiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/typologies")
public class TypologiesController {

    @Autowired
    private TypologiesService typologiesService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Typologies>> typologyById(@PathVariable Long id) {
        return ResponseEntity.ok(typologiesService.getTypologyById(id));
    }
}