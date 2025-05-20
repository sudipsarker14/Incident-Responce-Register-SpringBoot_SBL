package com.example.Incident_Response_Register.service;

import com.example.Incident_Response_Register.entity.DropdownOption;
import com.example.Incident_Response_Register.repository.DropdownOptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DropdownOptionService {


        @Autowired
        private DropdownOptionRepository repository;

        public List<DropdownOption> getOptionsByType(String type) {
            return repository.findByType(type);
        }

}
