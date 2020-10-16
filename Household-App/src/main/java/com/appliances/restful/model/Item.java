package com.appliances.restful.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "items")
public class Item {

	int id;
	String serialNumber;
	String brand;
	String model;
	String status;
	Date dateBought;
	

    public Item(int id, String serialNumber, String brand, String model,String status,Date dateBought) {
        super();
        this.id = id;
        this.serialNumber = serialNumber;
        this.brand = brand;
        this.model = model;
        this.status=status;
        this.dateBought= dateBought;
    }
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
    
    
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "serial_number", nullable = false)
	public String getSerialNumber() {
		return serialNumber;
	}
	
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	@Column(name = "brand", nullable = false)
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	@Column(name = "model", nullable = false)
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	@Column(name = "status", nullable = false)
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Column(name = "dateBought", nullable = false)
	public Date getDateBought() {
		return dateBought;
	}
	public void setDateBought(Date dateBought) {
		this.dateBought = dateBought;
	}
	@Override
	    public String toString() {
	        return "Item [id=" + id + ", serialNumber=" + serialNumber + ", brand=" + brand + ", model=" + model + ", status="+status+", dateBought="+dateBought+"]";
	    }
}
