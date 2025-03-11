package com.psicologia.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExpertDTO {

    private Long id;

    @NotBlank(message = "The name is mandatory")
    private String name;

    @NotBlank(message = "The lastname is mandatory")
    private String lastname;

    @NotBlank(message = "The email is mandatory")
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

    @NotBlank(message = "The profession is mandatory")
    private String profession;

    @NotBlank(message = "The area is mandatory")
    private String area;

    private boolean status;

    public ExpertDTO(Long id,String name, String email, String profession, String area, boolean status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.profession = profession;
        this.area = area;
        this.status = status;
    }
}

