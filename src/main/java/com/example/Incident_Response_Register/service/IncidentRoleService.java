package com.example.Incident_Response_Register.service;
import com.example.Incident_Response_Register.entity.Incidents;
import com.example.Incident_Response_Register.repository.IncidentRepo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class IncidentRoleService {

    @Autowired
    private IncidentRepo incidentRepository;


    public List<Incidents> getIncidentsByRole(String role) {
        switch (role.toUpperCase()) {
            case "IT_TEAM":
                return incidentRepository.findByNatureOfIncident("IT");
            case "MANMADE_TEAM":
                return incidentRepository.findByNatureOfIncident("Manmade");
            case "NATURE_TEAM":
                return incidentRepository.findByNatureOfIncident("Nature");
            default:
                return List.of(); // return empty list if unknown role
        }
    }
}
