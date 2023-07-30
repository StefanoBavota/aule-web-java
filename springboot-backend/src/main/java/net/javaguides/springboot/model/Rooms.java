package net.javaguides.springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "rooms")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rooms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "name")
    private String name;

    @NonNull
    @Column(name = "capacity")
    private int capacity;

    @Column(name = "description")
    private String description;

    @NonNull
    @Column(name = "electrical_outlets")
    private int electrical_outlets;

    @NonNull
    @Column(name = "ethernet_ports")
    private int ethernet_ports;

    @NonNull
    @Column(name = "link")
    private String link;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "supervisor_id")
    private Supervisors supervisors;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Groups groups;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Locations locations;

    @OneToMany(mappedBy = "rooms")
    private List<Events> events;

    @OneToMany(mappedBy = "rooms")
    private List<AssetsRoom> assetRooms;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getElectrical_outlets() {
        return electrical_outlets;
    }

    public void setElectrical_outlets(int electrical_outlets) {
        this.electrical_outlets = electrical_outlets;
    }

    public int getEthernet_ports() {
        return ethernet_ports;
    }

    public void setEthernet_ports(int ethernet_ports) {
        this.ethernet_ports = ethernet_ports;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Supervisors getSupervisors() {
        return supervisors;
    }

    public void setSupervisors(Supervisors supervisors) {
        this.supervisors = supervisors;
    }

    public Groups getGroups() {
        return groups;
    }

    public void setGroups(Groups groups) {
        this.groups = groups;
    }

    public Locations getLocations() {
        return locations;
    }

    public void setLocations(Locations locations) {
        this.locations = locations;
    }
}