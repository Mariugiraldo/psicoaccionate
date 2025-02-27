package com.psicologia.model;

import jakarta.persistence.*;

@Entity
@Table(name = "experts")
public class Expert extends Person {
    private Long id;
    private String profession;

    private String area;

    private boolean status;
}
