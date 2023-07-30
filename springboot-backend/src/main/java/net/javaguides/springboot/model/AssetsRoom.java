package net.javaguides.springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "asset_room")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssetsRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "asset_id")
    private Assets assets;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Rooms rooms;
}
