package com.example.Incident_Response_Register.repository;

import com.example.Incident_Response_Register.entity.Incidents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncidentRoleRepo extends JpaRepository <Incidents, Long> {
    List<Incidents> findByNatureOfIncident(String natureOfIncident);
}
