package net.javaguides.springboot.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "locations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
}
