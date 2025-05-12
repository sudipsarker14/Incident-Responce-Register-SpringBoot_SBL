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

    @GetMapping("/deshboard/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Incidents> getIncidentById(@PathVariable Long id) {
        Incidents incident = incidentService.findIncidentById(id);
        if (incident != null) {
            return ResponseEntity.ok(incident);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PatchMapping("/deshboard/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Incidents> updateIncident(
            @PathVariable Long id, @RequestBody Incidents updatedIncident) {

        Incidents incident = incidentService.getIncidentById(id)
                .orElseThrow();

        // Update fields with the new values
        incident.setDateOfIncident(updatedIncident.getDateOfIncident());
        incident.setReportingDate(updatedIncident.getReportingDate());
        incident.setNatureOfIncident(updatedIncident.getNatureOfIncident());
        incident.setPlaceOfIncident(updatedIncident.getPlaceOfIncident());
        incident.setBriefDescription(updatedIncident.getBriefDescription());
        incident.setActionsTaken(updatedIncident.getActionsTaken());
        incident.setIncidentStatus(updatedIncident.getIncidentStatus());
        incident.setCompletionDate(updatedIncident.getCompletionDate());
        incident.setInitiator(updatedIncident.getInitiator());
        incident.setResponsibleOfficer(updatedIncident.getResponsibleOfficer());
        incident.setImpact(updatedIncident.getImpact());
        incident.setSeverity(updatedIncident.getSeverity());
        incident.setStakeholders(updatedIncident.getStakeholders());
        incident.setActionsRequiredBy(updatedIncident.getActionsRequiredBy());
        incident.setRemarks(updatedIncident.getRemarks());


        incidentService.saveIncident(incident);

        return ResponseEntity.ok(incident);
    }

}