package com.example.Incident_Response_Register.repository;

import com.example.Incident_Response_Register.entity.Incidents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidentRepo extends JpaRepository<Incidents, Long> {

}



