package net.javaguides.springboot.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RoomsResponse {

    @JsonProperty
    private Long id;

    @JsonProperty
    private String name;

    @JsonProperty
    private Long capacity;

    @JsonProperty
    private String description;

    @JsonProperty
    private Long electricalOutlets;

    @JsonProperty
    private Long ethernetPorts;

    @JsonProperty
    private String link;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getElectricalOutlets() {
        return electricalOutlets;
    }

    public void setElectricalOutlets(Long electricalOutlets) {
        this.electricalOutlets = electricalOutlets;
    }

    public Long getEthernetPorts() {
        return ethernetPorts;
    }

    public void setEthernetPorts(Long ethernetPorts) {
        this.ethernetPorts = ethernetPorts;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public RoomsResponse() {
    }

    public RoomsResponse(Long id, String name, Long capacity, String description, Long electricalOutlets, Long ethernetPorts, String link) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.description = description;
        this.electricalOutlets = electricalOutlets;
        this.ethernetPorts = ethernetPorts;
        this.link = link;
    }
}
