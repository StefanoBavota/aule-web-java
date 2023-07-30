package net.javaguides.springboot.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference
    private Courses courses;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "event_id")
    @JsonBackReference
    private Events events;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Courses getCourses() {
        return courses;
    }
}
