package com.example.Incident_Response_Register.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "dropdown_options")
@Getter
@Setter
public class DropdownOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String value;


    public DropdownOption() {}

    public DropdownOption(String type, String value) {
        this.type = type;
        this.value = value;
    }

}
