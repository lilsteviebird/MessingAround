package com.firsttry.Steven.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Device {
	
	private String deviceType;
	private int totalStock;
	private String deviceDescrip;
	
	@Id
	private String iD;
	
	public Device(String type, int stock, String description) {
		this.deviceType = type;
		this.totalStock = stock;
		this.deviceDescrip = description;
		this.iD = UUID.randomUUID().toString();
	}
	
	public Device() {
		this.iD = UUID.randomUUID().toString();
	}
	
	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public int getTotalStock() {
		return totalStock;
	}

	public void setTotalStock(int totalStock) {
		this.totalStock = totalStock;
	}

	public String getDeviceDescrip() {
		return deviceDescrip;
	}

	public void setDeviceDescrip(String deviceDescrip) {
		this.deviceDescrip = deviceDescrip;
	}

	public String getiD() {
		return iD;
	}

	public void setiD(String iD) {
		this.iD = iD;
	}

}
