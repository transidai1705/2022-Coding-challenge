package com.axon.location.tracking.api;

import com.axon.location.tracking.api.event.message.EventMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class Receiver {
	private ObjectMapper objectMapper = new ObjectMapper();

	@Autowired
	private DataStore dataStore;

	public void receiveMessage(String message) throws JsonProcessingException {
		System.out.println(message);
		EventMessage eventMessage = objectMapper.readValue(message, EventMessage.class);
		System.out.println(eventMessage);

		switch (eventMessage.getType()) {
			case IncidentOccurred:
				dataStore.getIncidents().add(
						Incident.builder().id(eventMessage.getIncidentId()).codeName(eventMessage.getCodeName()).loc(eventMessage.getLoc()).build());
			case IncidentResolved:
				dataStore.setIncidents(dataStore.getIncidents().stream().filter(i -> i.getId() != eventMessage.getIncidentId()).collect(Collectors.toList()));
			case OfficerGoesOffline:
				dataStore.setOfficers(dataStore.getOfficers().stream().filter(i -> i.getNumber() != eventMessage.getOfficeId()).collect(Collectors.toList()));
			case OfficerLocationUpdated:
				dataStore.getOfficers().forEach(i -> {
					if (i.getNumber() == eventMessage.getOfficeId()) {
						i.setLoc(eventMessage.getLoc());
					}
				});
			case OfficerGoesOnline:
		}
	}
}
