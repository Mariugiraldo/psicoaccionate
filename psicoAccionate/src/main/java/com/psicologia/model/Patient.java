package com.psicologia.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "patients")
public class Patient extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private List<String> medications;
    private boolean reincident;

}
