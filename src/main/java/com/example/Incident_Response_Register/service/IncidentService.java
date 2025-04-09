package com.example.Incident_Response_Register.service;
import com.example.Incident_Response_Register.repository.IncidentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Incident_Response_Register.entity.Incidents;


@Service
public class IncidentService {

    @Autowired
    IncidentRepo incidentRepo;

    public Incidents addIncident(Incidents incident) {

        return incidentRepo.save(incident);
    }
}

