package com.example.Incident_Response_Register.controller;
import com.example.Incident_Response_Register.entity.Incidents;
import com.example.Incident_Response_Register.service.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IncidentController {

    @Autowired
    IncidentService incidentService;

    @PostMapping("/addIncident")
    @CrossOrigin(origins = "http://localhost:3000")
    public Incidents addIncident(@RequestBody Incidents incident) {
        return incidentService.addIncident(incident);
    }
}