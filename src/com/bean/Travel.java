package com.bean;

import com.util.TravelEnum;

public class Travel implements Expense {
	private TravelEnum travelType;
	private double travelAmount;
	private int travelDay;
	private int month;
	public TravelEnum getTravelType() {
		return travelType;
	}
	public int getTravelDay() {
		return travelDay;
	}
	public void setTravelDay(int travelDay) {
		this.travelDay = travelDay;
	}
	public void setTravelType(TravelEnum travelType) {
		this.travelType = travelType;
	}
	public double getTravelAmount() {
		return travelAmount;
	}
	public void setTravelAmount(double travelAmount) {
		this.travelAmount = travelAmount;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	@Override
	public String toString() {
		return "Travel [travelType=" + travelType + ", travelAmount="
				+ travelAmount + ", travelDay=" + travelDay + ", month="
				+ month + "]";
	}
	

}
