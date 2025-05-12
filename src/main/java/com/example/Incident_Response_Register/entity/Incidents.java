package com.example.Incident_Response_Register.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Incidents {

    public Incidents() {

    }

    public Incidents(Long incidentNo, String dateOfIncident, String briefDescription, String reportingDate, String natureOfIncident, String placeOfIncident, String actionsTaken, String incidentStatus, String completionDate, String initiator, String responsibleOfficer, String impact, String severity, String stakeholders, String actionsRequiredBy, String remarks) {
        this.incidentNo = incidentNo;
        this.dateOfIncident = dateOfIncident;
        this.reportingDate = reportingDate;
        this.natureOfIncident = natureOfIncident;
        this.placeOfIncident = placeOfIncident;
        this.briefDescription = briefDescription;
        this.actionsTaken = actionsTaken;
        this.incidentStatus = incidentStatus;
        this.completionDate = completionDate;
        this.initiator = initiator;
        this.responsibleOfficer = responsibleOfficer;
        this.impact = impact;
        this.severity = severity;
        this.stakeholders = stakeholders;
        this.actionsRequiredBy = actionsRequiredBy;
        this.remarks = remarks;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long incidentNo;
    private String dateOfIncident;
    private String reportingDate;
    private String natureOfIncident;
    private String placeOfIncident;
    private String briefDescription;
    private String actionsTaken;
    private String incidentStatus;
    private String completionDate;
    private String initiator;
    private String responsibleOfficer;
    private String impact;
    private String severity;
    private String stakeholders;
    private String actionsRequiredBy;
    private String remarks;
}
