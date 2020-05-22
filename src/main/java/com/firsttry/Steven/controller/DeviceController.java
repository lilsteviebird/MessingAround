package com.firsttry.Steven.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firsttry.Steven.model.Device;
import com.firsttry.Steven.model.DeviceRepository;

@RestController
@RequestMapping("/api")
public class DeviceController {
	
	@Autowired
	private DeviceRepository repo;
	
	public DeviceController(DeviceRepository repo) {
		this.repo = repo;
	}
	
	
	@GetMapping("/devices")
	ResponseEntity<List <Device>> allDevices(){
		return ResponseEntity.ok(repo.findAll());
	}
	
	@PostMapping("/devices")
	ResponseEntity<Device> newDevice(@RequestBody Device newDevice) throws URISyntaxException{
		repo.save(newDevice);
		return ResponseEntity.created(new URI("/api/deviceInfo/" + newDevice.getiD())).body(newDevice);
	}
	
	@DeleteMapping("/devices/{id}")
	ResponseEntity<?> deleteDevice(@PathVariable String id){
		Optional<Device> deleteMe = repo.findById(id);
		repo.delete(deleteMe.get());
		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/devices/{id}")
	ResponseEntity<Device> replaceDeviceInfo(@RequestBody Device device, @PathVariable String id){
		Device editDevice = (Device) repo.findById(id).get();
		editDevice.setTotalStock(device.getTotalStock());
		editDevice.setDeviceType(device.getDeviceType());
		editDevice.setDeviceDescrip(device.getDeviceDescrip());
		
		return ResponseEntity.ok((Device) repo.save(editDevice));
	}

}
