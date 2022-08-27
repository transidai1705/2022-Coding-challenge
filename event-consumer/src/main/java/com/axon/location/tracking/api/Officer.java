package com.axon.location.tracking.api;

import com.axon.location.tracking.api.event.message.LocationDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Officer {
    private int number;
    private String badgeName;
    private LocationDTO loc;
}
