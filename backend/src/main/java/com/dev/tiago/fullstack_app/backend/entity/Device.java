package com.dev.tiago.fullstack_app.backend.entity;

import com.dev.tiago.fullstack_app.backend.enums.DeviceStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String categoryDevice; //printer, screen, mouse, scanner, pen wifi, pc, keyboard
    private String model;
    private String brand;
    private DeviceStatus status = DeviceStatus.AVAILABLE;

}
