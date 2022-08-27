package com.axon.location.tracking.api.dto;

import com.axon.location.tracking.api.Incident;
import com.axon.location.tracking.api.Officer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MapData {
    private List<Incident> incidents;
    private List<Officer> officers;
}
