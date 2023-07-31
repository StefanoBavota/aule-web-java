package net.javaguides.springboot.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.javaguides.springboot.model.Events;
import net.javaguides.springboot.model.Rooms;
import net.javaguides.springboot.model.Supervisors;
import net.javaguides.springboot.model.Typologies;

@Data
@ToString
public class EventsRequest {

    @JsonProperty
    private String date;

    @JsonProperty
    private String startTime;

    @JsonProperty
    private String endTime;

    @JsonProperty
    private String name;

    @JsonProperty
    private String description;

    @JsonProperty
    private Rooms room;

    @JsonProperty
    private Supervisors supervisor;

    @JsonProperty
    private Typologies typology;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Rooms getRoom() {
        return room;
    }

    public void setRoom(Rooms room) {
        this.room = room;
    }

    public Supervisors getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisors supervisors) {
        this.supervisor = supervisors;
    }

    public Typologies getTypology() {
        return typology;
    }

    public void setTypology(Typologies typology) {
        this.typology = typology;
    }

    public EventsRequest() {
    }

    public EventsRequest(String date, String startTime, String endTime, String name, String description, Rooms room, Supervisors supervisor, Typologies typology) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.name = name;
        this.description = description;
        this.room = room;
        this.supervisor = supervisor;
        this.typology = typology;
    }
}
