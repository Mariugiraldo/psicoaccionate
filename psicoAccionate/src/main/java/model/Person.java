package model;

import com.mysql.cj.jdbc.Blob;
import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Person {
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


}
