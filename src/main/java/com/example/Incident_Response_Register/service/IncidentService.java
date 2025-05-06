package com.example.Incident_Response_Register.service;
import com.example.Incident_Response_Register.repository.IncidentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Incident_Response_Register.entity.Incidents;

import java.util.List;


@Service
public class IncidentService {
    @Autowired
    IncidentRepo incidentRepo;


    public List<Incidents> getAllIncidents() {
        return incidentRepo.findAll();
    }
    public Incidents addIncident(Incidents incident) {

        return incidentRepo.save(incident);
    }
    public void deleteIncidentById(Long id) {
        incidentRepo.deleteById(id);
    }
    public void deleteIncidentsByIds(List<Long> ids) {
        incidentRepo.deleteAllById(ids);
    }

}

