package com.axon.location.tracking.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataStore {
    private List<Incident> incidents;
    private List<Officer> officers;
}
