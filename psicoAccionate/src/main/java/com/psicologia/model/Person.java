package com.psicologia.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Blob;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "persons")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastname;

    private String email;

    private LocalDate birthdate;

    private String documentType;

    private String document;

    private String country;

    private String city;

    private String zipcode;

    private String address;

    private String phone;

    private String gender;

    private String maritalStatus;

    private Blob picture;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

    public Person(String name, String lastname, String email, LocalDate birthdate,
                  String documentType, String document, String country, String city,
                  String phone, String gender) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.birthdate = birthdate;
        this.documentType = documentType;
        this.document = document;
        this.country = country;
        this.city = city;
        this.phone = phone;
        this.gender = gender;
    }
}
