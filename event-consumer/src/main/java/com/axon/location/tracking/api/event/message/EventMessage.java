package com.axon.location.tracking.api.event.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventMessage {
    private EventType type;
    private Integer incidentId;
    private String codeName;
    private LocationDTO loc;
    private int officeId;
    private String badgeName;
}
