package com.psicologia.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExpertDTO {
    private Long id;

    private String profession;

    private String area;

    private boolean status;

}

