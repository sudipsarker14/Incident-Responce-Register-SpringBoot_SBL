package com.example.Incident_Response_Register.controller;

import com.example.Incident_Response_Register.entity.DropdownOption;
import com.example.Incident_Response_Register.service.DropdownOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dropdowns")
@CrossOrigin(origins = "http://localhost:3000")
public class DropdownOptionController {

        @Autowired
        private DropdownOptionService service;

        @GetMapping("/{type}")
        public ResponseEntity<List<DropdownOption>> getOptions(@PathVariable String type) {
            List<DropdownOption> options = service.getOptionsByType(type);
            return ResponseEntity.ok(options);
        }
}
