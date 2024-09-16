package com.dev.tiago.fullstack_app.backend.repository;

import com.dev.tiago.fullstack_app.backend.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {
}
