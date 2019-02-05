package com.booking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HostelAllocation {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	private String hostelName;	
	private double pricePerDay;
	private int nbOfDays;
	
	public HostelAllocation() {}
	
	public HostelAllocation(String hostelName, double pricePerDay, int nbOfDays) {
		
		this.hostelName = hostelName;
		this.pricePerDay = pricePerDay;
		this.nbOfDays = nbOfDays;
	}

	public String getHostelName() {
		return hostelName;
	}

	public void setHostelName(String hostelName) {
		this.hostelName = hostelName;
	}

	public double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public int getNbOfDays() {
		return nbOfDays;
	}

	public void setNbOfDays(int nbOfDays) {
		this.nbOfDays = nbOfDays;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getTotalPrice() {
		return pricePerDay * nbOfDays;
	}
}
