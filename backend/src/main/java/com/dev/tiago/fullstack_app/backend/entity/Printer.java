package com.dev.tiago.fullstack_app.backend.entity;

import jakarta.persistence.Entity;
import lombok.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Printer extends Device {

    private String serialNumber;
    private String section; //it will be a class too to store all the sections
    private String function; //it will be another class
    private String workbench; //another class
}
