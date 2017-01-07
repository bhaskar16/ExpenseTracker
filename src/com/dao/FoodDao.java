package com.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.bean.Bill;
import com.bean.Food;
import com.util.FoodEnum;

public class FoodDao {
	
	public ArrayList<Food> displayAllFood(){
		
		    String csvFile = "D://Test//Food.txt";
	        BufferedReader br = null;
	        String line = "";
	        String cvsSplitBy = ",";
	        
	        ArrayList<Food> allFood = new ArrayList<Food>();
	        
	        try{
	        	  br = new BufferedReader(new FileReader(csvFile));
	              while ((line = br.readLine()) != null) {
	              	Food fb = new Food();
	                  // use comma as separator
	                String[] foodbills = line.split(cvsSplitBy);
	                switch(foodbills[0]){
	                case "Daily":{
	                	fb.setFoodType(FoodEnum.FOOD_DAILY);
	                	break;
	                }
	                case "Rest":{
	                	fb.setFoodType(FoodEnum.FOOD_RESTAURANT);
	                	break;
	                }
	                case "Misc":{
	                	fb.setFoodType(FoodEnum.FOOD_MISC);
	                	break;
	                }
	                default:break;
	                }
	                try{
	                fb.setFoodPrice(Double.parseDouble(foodbills[1]));
	                fb.setDay(Integer.parseInt(foodbills[2]));
	                fb.setMonth(Integer.parseInt(foodbills[3]));
	                fb.setRestaurantName(foodbills[4]);
	                allFood.add(fb);
	                }
	                catch(Exception e){
	                	continue;
	                }
	        }
	        }catch(Exception e){
	        	e.printStackTrace();

	        }
		return allFood;
	}

	public ArrayList<Food> displayAllDailyFood() {
		String csvFile = "D://Test//Food.txt";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        
        ArrayList<Food> allFood = new ArrayList<Food>();
        
        try{
        	  br = new BufferedReader(new FileReader(csvFile));
              while ((line = br.readLine()) != null) {
              	Food fb = new Food();
                  // use comma as separator
                String[] foodbills = line.split(cvsSplitBy);
                switch(foodbills[0]){
                case "Daily":{
                	fb.setFoodType(FoodEnum.FOOD_DAILY);
                	break;
                }
                case "Rest":{
                	continue;
                }
                case "Misc":{
                	continue;
                }
                default:break;
                }
                try{
                fb.setFoodPrice(Double.parseDouble(foodbills[1]));
                fb.setDay(Integer.parseInt(foodbills[2]));
                fb.setMonth(Integer.parseInt(foodbills[3]));
                fb.setRestaurantName(foodbills[4]);
                if(fb.getFoodType().equals(FoodEnum.FOOD_DAILY))
                	allFood.add(fb);
                }catch(Exception e){
                	continue;
                }
        }
        }catch(Exception e){
        	e.printStackTrace();
        }
	return allFood;
	}
	
	public ArrayList<Food> displayAllMiscFood() {
		String csvFile = "D://Test//Food.txt";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        
        ArrayList<Food> allFood = new ArrayList<Food>();
        
        try{
        	  br = new BufferedReader(new FileReader(csvFile));
              while ((line = br.readLine()) != null) {
              	Food fb = new Food();
                  // use comma as separator
                String[] foodbills = line.split(cvsSplitBy);
                switch(foodbills[0]){
                case "Daily":{
                	fb.setFoodType(FoodEnum.FOOD_DAILY);
                	break;
                }
                case "Rest":{
                	fb.setFoodType(FoodEnum.FOOD_RESTAURANT);
                	break;
                }
                case "Misc":{
                	fb.setFoodType(FoodEnum.FOOD_MISC);
                	break;
                }
                default:break;
                }
                try{
                fb.setFoodPrice(Double.parseDouble(foodbills[1]));
                fb.setDay(Integer.parseInt(foodbills[2]));
                fb.setMonth(Integer.parseInt(foodbills[3]));
                fb.setRestaurantName(foodbills[4]);
                if(fb.getFoodType().equals(FoodEnum.FOOD_MISC))
                	allFood.add(fb);
                }
                catch(Exception e){
                	continue;
                }
        }
        }catch(Exception e){
        	e.printStackTrace();
        	System.out.println("An error occured. Please exit");
        }
	return allFood;
	}

	public ArrayList<Food> displayAllRestFood() {
		String csvFile = "D://Test//Food.txt";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        
        ArrayList<Food> allFood = new ArrayList<Food>();
        
        try{
        	  br = new BufferedReader(new FileReader(csvFile));
              while ((line = br.readLine()) != null) {
              	Food fb = new Food();
                  // use comma as separator
                String[] foodbills = line.split(cvsSplitBy);
                switch(foodbills[0]){
                case "Daily":{
                	fb.setFoodType(FoodEnum.FOOD_DAILY);
                	break;
                }
                case "Rest":{
                	fb.setFoodType(FoodEnum.FOOD_RESTAURANT);
                	break;
                }
                case "Misc":{
                	fb.setFoodType(FoodEnum.FOOD_MISC);
                	break;
                }
                default:break;
                }
                try{
                fb.setFoodPrice(Double.parseDouble(foodbills[1]));
                fb.setDay(Integer.parseInt(foodbills[2]));
                fb.setMonth(Integer.parseInt(foodbills[3]));
                fb.setRestaurantName(foodbills[4]);
                if(fb.getFoodType().equals(FoodEnum.FOOD_RESTAURANT))
                	allFood.add(fb);
                }catch(Exception e){
                	continue;
                }
        }
        }catch(Exception e){
        	e.printStackTrace();
        	System.out.println("An error occured. Please exit");

        }
	return allFood;
	}
	public boolean writeFood(Food f) throws IOException{
		
		
	    BufferedWriter out = new BufferedWriter(new FileWriter("D://Test//Food.txt",true));
	
	    StringBuilder sb = new StringBuilder();
        sb.append("\n");
        
        if(f.getFoodType().equals(FoodEnum.FOOD_DAILY))
        	sb.append("Daily,");
        else if(f.getFoodType().equals(FoodEnum.FOOD_RESTAURANT))
        	sb.append("Rest,");
        else  if(f.getFoodType().equals(FoodEnum.FOOD_MISC))
        	sb.append("Misc,");
        sb.append(""+f.getFoodPrice()+",");
        sb.append(""+f.getDay()+",");
        sb.append(f.getMonth()+",");
        sb.append(""+f.getRestaurantName());
        
        
        out.write(sb.toString());
        out.newLine();out.close();
        
        System.out.println("done!");
	
	
	
		return false;
	}

}
