package com.firsttry.Steven.model;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface DeviceRepository<T> extends JpaRepository<Device, String>{
	
	Optional<Device> findByDeviceType(String deviceType);
}