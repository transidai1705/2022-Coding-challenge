package com.axon.location.tracking.api;

import com.axon.location.tracking.api.dto.ErrorData;
import com.axon.location.tracking.api.dto.MapData;
import com.axon.location.tracking.api.dto.MapStateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StateRestController {

    @Autowired
    private DataStore dataStore;

    @GetMapping("/api/v1/status")
    MapStateDTO getState() {
        return MapStateDTO.builder()
                .data(MapData.builder().incidents(dataStore.getIncidents()).officers(dataStore.getOfficers()).build())
                .error(new ErrorData())
                .build();
    }
}
