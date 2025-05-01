package com.example.Incident_Response_Register.controller;
import com.example.Incident_Response_Register.entity.Incidents;
import com.example.Incident_Response_Register.repository.IncidentRepo;
import com.example.Incident_Response_Register.service.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IncidentController {

    @Autowired
    IncidentService incidentService;
    @Autowired
    private IncidentRepo incidentRepo;

    @PostMapping("/addIncident")
    @CrossOrigin(origins = "http://localhost:3000")
    public Incidents addIncident(@RequestBody Incidents incident) {
        return incidentService.addIncident(incident);
    }
    @GetMapping("/deshboard")
    @CrossOrigin(origins = "http://localhost:3000")
    List<Incidents> all() {
        return incidentRepo.findAll();
    }

    @GetMapping("/deshboard/{id}")
    Incidents one(@PathVariable Long id) {
        return incidentRepo.findById(id)
                .orElseThrow();
    }
    @DeleteMapping("/deshboard/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    void deleteIncident(@PathVariable Long id) {
        incidentRepo.deleteById(id);
    }
}