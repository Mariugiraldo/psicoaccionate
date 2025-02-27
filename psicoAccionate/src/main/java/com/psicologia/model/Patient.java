package com.psicologia.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "patients")
public class Patient extends Person {
    private List<String> medications;
    private boolean reincident;

}
