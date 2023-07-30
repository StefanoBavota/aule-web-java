package net.javaguides.springboot.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.javaguides.springboot.model.Events;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EventsRequest {

    private String date;
    private String startTime;
    private String endTime;
    private String name;
    private String description;
    private long room_id;
    private long supervisor_id;
    private long typology_id;
}
