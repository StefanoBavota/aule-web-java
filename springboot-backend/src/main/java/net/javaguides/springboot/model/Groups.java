package net.javaguides.springboot.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "my_groups")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Groups {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "name")
    private String name;

    @NonNull
    @Column(name = "description")
    private String description;

    @NonNull
    @Column(name = "link")
    private String link;

    @OneToMany(mappedBy = "groups")
    private List<Rooms> rooms;
}
