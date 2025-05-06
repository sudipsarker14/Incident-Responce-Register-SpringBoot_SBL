package com.example.Incident_Response_Register.controller;
import com.example.Incident_Response_Register.entity.Incidents;
import com.example.Incident_Response_Register.repository.IncidentRepo;
import com.example.Incident_Response_Register.service.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IncidentController {

   @Autowired
    IncidentService incidentService;

    @PostMapping("/addIncident")
    @CrossOrigin(origins = "http://localhost:3000")
    public Incidents addIncident(@RequestBody Incidents incident) {
        return incidentService.addIncident(incident);
    }
    @GetMapping("/deshboard")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Incidents> getAllIncidents() {
        return incidentService.getAllIncidents();
    }

    @DeleteMapping("/deshboard/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public void deleteIncident(@PathVariable Long id) {
        incidentService.deleteIncidentById(id);
    }

    @DeleteMapping("/deshboard/delete-multiple")
    @CrossOrigin(origins = "http://localhost:3000")
    public void deleteMultipleIncidents(@RequestBody List<Long> ids) {
        incidentService.deleteIncidentsByIds(ids);
    }

}