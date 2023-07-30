package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Groups;
import net.javaguides.springboot.repository.GroupsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
public class GroupsController {

    @Autowired
    private GroupsRepository groupsRepository;

    @GetMapping
    public List<Groups> getAllGroups() {
        return groupsRepository.findAll();
    }
}
