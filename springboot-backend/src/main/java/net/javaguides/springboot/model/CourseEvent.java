package net.javaguides.springboot.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "course_event")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Courses courses;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Events events;
}
