package com.sunsoft.common.model;

public class ElectricMeter {
	private int id;
	private int cpu;
	private int units;
	private int bill;
	private String lastDate;
	
	public ElectricMeter(int id, int cpu, int units, int bill, String lastDate) 
	{
		this.id=id;
		this.cpu=cpu;
		this.units=units;
		this.bill=bill;
		this.lastDate=lastDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCpu() {
		return cpu;
	}

	public void setCpu(int cpu) {
		this.cpu = cpu;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public int getBill() {
		return bill;
	}

	public void setBill(int bill) {
		this.bill = bill;
	}

	public String getLastDate() {
		return lastDate;
	}

	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}

	
	
	
	
	
	
}
