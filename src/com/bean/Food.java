package com.bean;

import java.util.Comparator;

import com.util.FoodEnum;

public class Food implements Expense,Comparable<Food> {
	private double foodPrice;
	private String restaurantName;
	private int day;
	private int month;
	private FoodEnum foodType;
	public double getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}

	public FoodEnum getFoodType() {
		return foodType;
	}

	public void setFoodType(FoodEnum foodType) {
		this.foodType = foodType;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	@Override
	public String toString() {
		return "Food [foodPrice=" + foodPrice + ", restaurantName="
				+ restaurantName + ", day=" + day + ", month=" + month
				+ ", foodType=" + foodType + "]";
	}
	
	@Override
	public int compareTo(Food f) {
		return (int) (getFoodPrice()-f.getFoodPrice());
	}

	
	public static Comparator<Food> FoodNameComparator = new Comparator<Food>(){

		@Override
		public int compare(Food o1, Food o2) {
			return o1.getRestaurantName().compareToIgnoreCase(o2.getRestaurantName());
		}
		
	};
	
	
	public static Comparator<Food> FoodMonthComparator = new Comparator<Food>(){

		@Override
		public int compare(Food o1, Food o2) {
			// TODO Auto-generated method stub
			return -(o1.getMonth()-o2.getMonth());
		}
		
	};
	
	
	

}
