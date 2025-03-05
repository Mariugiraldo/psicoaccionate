package com.psicologia.dto;

import com.psicologia.model.Person;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExpertDTO {

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

    public ExpertDTO(String name, String email, String profession, String area, boolean status) {
        this.name = name;
        this.email = email;
        this.profession = profession;
        this.area = area;
        this.status = status;
    }
}

