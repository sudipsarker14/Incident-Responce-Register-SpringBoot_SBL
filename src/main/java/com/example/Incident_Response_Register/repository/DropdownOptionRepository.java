package com.example.Incident_Response_Register.repository;

import com.example.Incident_Response_Register.entity.DropdownOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DropdownOptionRepository extends JpaRepository<DropdownOption, Long> {
    List<DropdownOption> findByType(String type);
}
