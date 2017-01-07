package com.bean;

import com.util.GiftEnum;

public class Gift implements Expense {
	private String giftTo;
	private GiftEnum giftOccasion;
	private double giftAmount;
	private int month;
	private int year;
	public String getGiftTo() {
		return giftTo;
	}
	public void setGiftTo(String giftTo) {
		this.giftTo = giftTo;
	}
	
	public GiftEnum getGiftOccasion() {
		return giftOccasion;
	}
	public void setGiftOccasion(GiftEnum giftOccasion) {
		this.giftOccasion = giftOccasion;
	}
	public double getGiftAmount() {
		return giftAmount;
	}
	public void setGiftAmount(double giftAmount) {
		this.giftAmount = giftAmount;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return "Gift [giftTo=" + giftTo + ", giftOccasion=" + giftOccasion
				+ ", giftAmount=" + giftAmount + ", month=" + month + ", year="
				+ year + "]";
	}
	
	

}
