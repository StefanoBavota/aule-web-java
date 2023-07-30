package net.javaguides.springboot.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "assets")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Assets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "assets")
    private List<AssetsRoom> assetsRooms;
}
