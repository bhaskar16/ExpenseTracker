package com.bean;

public class Budget {
	
	
	private double budget;
	private double special_budget=3000;
	
	public double trackBudget(double expense){
		
		budget = 2500;
		budget-= expense;
		if(budget<0){
			System.out.println("Special Budget allowance");
			special_budget -= budget;
			return special_budget;
			
		}
		return budget;
		
	}
	
	

}
