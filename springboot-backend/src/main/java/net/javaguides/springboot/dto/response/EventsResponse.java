package net.javaguides.springboot.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EventsResponse {

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

    @JsonProperty("typology_id")
    private Long typologyId;

    @JsonProperty("supervisor_id")
    private Long supervisorId;

    @JsonProperty("room_id")
    private Long roomId;

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

    public Long getTypologyId() {
        return typologyId;
    }

    public void setTypologyId(Long typologyId) {
        this.typologyId = typologyId;
    }

    public Long getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(Long supervisorId) {
        this.supervisorId = supervisorId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public EventsResponse() {
    }

    public EventsResponse(String date, String startTime, String endTime, String name, String description, long roomId, long supervisorId, long typologyId) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.name = name;
        this.description = description;
        this.roomId = roomId;
        this.supervisorId = supervisorId;
        this.typologyId = typologyId;
    }
}
