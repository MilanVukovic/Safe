package com.example.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Device;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long>{

}
