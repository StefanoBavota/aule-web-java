package net.javaguides.springboot.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "locations")
public class Locations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "place")
    private String place;

    @NonNull
    @Column(name = "building")
    private String building;

    @NonNull
    @Column(name = "floor")
    private String floor;

    @OneToMany(mappedBy = "locations")
    private List<Rooms> rooms;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public List<Rooms> getRooms() {
        return rooms;
    }

    public void setRooms(List<Rooms> rooms) {
        this.rooms = rooms;
    }

    public Locations() {
    }

    public Locations(Long id, String place, String building, String floor, List<Rooms> rooms) {
        this.id = id;
        this.place = place;
        this.building = building;
        this.floor = floor;
        this.rooms = rooms;
    }
}
