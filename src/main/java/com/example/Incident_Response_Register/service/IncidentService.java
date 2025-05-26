package com.example.Incident_Response_Register.service;
import com.example.Incident_Response_Register.repository.IncidentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;
import com.example.Incident_Response_Register.entity.Incidents;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;


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

    public Optional<Incidents> getIncidentById(Long id) {
        return incidentRepo.findById(id);
    }
    public Incidents findIncidentById(Long id) {
        return incidentRepo.findById(id).orElse(null);
    }

    public Incidents saveIncident(Incidents incident) {
        return incidentRepo.save(incident);
    }

    public List<Incidents> getIncidentsByRole(String role) {
        switch (role) {
            case "IT_TEAM":
                return incidentRepo.findByNatureOfIncident("IT Related Incident");
            case "MANMADE_TEAM":
                return incidentRepo.findByNatureOfIncident("Manmade Incident");
            case "NATURE_TEAM":
                return incidentRepo.findByNatureOfIncident("Natural Calamities Incident");
            default:
               return new ArrayList<>(); // return empty list if unknown role
        }
    }
}


