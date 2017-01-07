package com.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.dao.BillDao;
import com.dao.FoodDao;
import com.dao.GiftDao;
import com.dao.MovieDao;
import com.dao.TravelDao;
import com.util.BillEnum;
import com.util.TravelEnum;


public class ExpenseTracker {
	private ArrayList<Bill> allBills;
	private ArrayList<Bill> allPaidBills;
	private ArrayList<Bill> allUnpaidBills;
	private HashMap<Integer,ArrayList<Bill>> billForMonth;
	
	
	private ArrayList<Movie> allMovies;
	
	
	
	
	
	private ArrayList<Food> getAllFoodExpenses;
	private ArrayList<Food> getAllDailyFoodExpenses;
	private ArrayList<Food> getAllMiscFoodExpenses;
	private ArrayList<Food> getAllRestFoodExpenses;
	
	private ArrayList<Gift> allGifts ;
	
	
	private ArrayList<Travel> allTravel;
	private ArrayList<Travel> allDailyTravel;
	private ArrayList<Travel> allMiscTravel;
	
	
	
	public ArrayList<Bill> getAllBills(){
		BillDao bd = new BillDao();
		allBills = bd.displayBill();
		
		
		return allBills;
	}
	
	public ArrayList<Bill> getAllPaidBills(){
		BillDao bd = new BillDao();
		allPaidBills = new ArrayList<Bill>();
		allBills = bd.displayBill();
		for(Bill b : allBills){
			if(b.isBillPaid())
				allPaidBills.add(b);
		}
		return allPaidBills;
	}
	
	public ArrayList<Bill> getAllUnpaidBills(){
		BillDao bd = new BillDao();
		allBills = bd.displayBill();
		allUnpaidBills =  new ArrayList<Bill>();
		for(Bill b : allBills){
			if(!b.isBillPaid())
				allUnpaidBills.add(b);
		}
		
		
		
		return allUnpaidBills;
	}
	
	public HashMap<Integer,ArrayList<Bill>> getBillsByMonth(){
		BillDao bd = new BillDao();
		
		
		allBills = bd.displayBill();
		billForMonth = new HashMap<Integer,ArrayList<Bill>>();	
		ArrayList<Bill> ab1 = new ArrayList<Bill>();ArrayList<Bill> ab2 = new ArrayList<Bill>();
		ArrayList<Bill> ab3 = new ArrayList<Bill>();ArrayList<Bill> ab4 = new ArrayList<Bill>();
		ArrayList<Bill> ab6 = new ArrayList<Bill>();ArrayList<Bill> ab5 = new ArrayList<Bill>();
		ArrayList<Bill> ab7 = new ArrayList<Bill>();ArrayList<Bill> ab8 = new ArrayList<Bill>();
		ArrayList<Bill> ab10 = new ArrayList<Bill>();ArrayList<Bill> ab9 = new ArrayList<Bill>();
		ArrayList<Bill> ab11 = new ArrayList<Bill>();ArrayList<Bill> ab12 = new ArrayList<Bill>();
		for(Bill b : allBills){
			if(b.getBillMonth() == 1){
				ab1.add(b);
				billForMonth.put(b.getBillMonth(),ab1);
			}
			if(b.getBillMonth() == 2){
				ab2.add(b);
				billForMonth.put(b.getBillMonth(),ab2);
			}
			if(b.getBillMonth() == 3){
				ab3.add(b);
				billForMonth.put(b.getBillMonth(),ab3);
			}
			if(b.getBillMonth() == 4){
				ab4.add(b);
				billForMonth.put(b.getBillMonth(),ab4);
			}
			if(b.getBillMonth() == 5){
				ab5.add(b);
				billForMonth.put(b.getBillMonth(),ab5);
			}
			if(b.getBillMonth() == 6){
				ab6.add(b);
				billForMonth.put(b.getBillMonth(),ab6);
			}
			if(b.getBillMonth() == 7){
				ab7.add(b);
				billForMonth.put(b.getBillMonth(),ab7);
			}
			if(b.getBillMonth() == 8){
				ab8.add(b);
				billForMonth.put(b.getBillMonth(),ab8);
			}
			if(b.getBillMonth() == 9){
				ab9.add(b);
				billForMonth.put(b.getBillMonth(),ab9);
			}
			
			if(b.getBillMonth() == 10){
				ab10.add(b);
				billForMonth.put(b.getBillMonth(),ab10);
			}
			if(b.getBillMonth() == 11){
				ab11.add(b);
				billForMonth.put(b.getBillMonth(),ab11);
			}
			if(b.getBillMonth() == 12){
				ab12.add(b);
				billForMonth.put(b.getBillMonth(),ab12);
			}
				
			
		}
		
		return billForMonth;
	}
	
	
	//Do NOT Use. 
	public LinkedHashMap<Integer,Bill> getBillsByMonthLinked(){
		BillDao bd = new BillDao();
		
		LinkedHashMap<Integer,Bill> lhm = new LinkedHashMap<Integer,Bill>();
		allBills = bd.displayBill();
		
		for(Bill b : allBills){
			lhm.put(b.getBillMonth(), b);
		}
		
		return lhm;
	}
	
	
	public ArrayList<Bill> getSpecificBill(BillEnum bill){
		ArrayList<Bill> specificBills = new ArrayList<Bill>();
		BillDao bd = new BillDao();
		allBills = bd.displayBill();
		for (Bill b : allBills)
		{
			if(b.getBillName().equals(bill))
				specificBills.add(b);
		}
		return specificBills;
	}
	
	public Bill getSpecificBillSpecificMonth(BillEnum bill,int month){
		
		BillDao bd = new BillDao();
		allBills = bd.displayBill();
		for (Bill b : allBills)
		{
			if((b.getBillName().equals(bill)) && b.getBillMonth() == month)
				return b;
				
		}
		return null;
	}
	
	public Bill getSpecificBill(int month){
		return null;
	}
	
	public ArrayList<Travel> findAllTravelCost(){
		TravelDao td = new TravelDao();
		allTravel = td.displayTravel();
		return allTravel;
	}
	
	public ArrayList<Travel> findAllDailyTravelCost(){
		TravelDao td = new TravelDao();
		allDailyTravel = new ArrayList<Travel>();
		allTravel = td.displayTravel();
		for(Travel t:allTravel)
		{
			if(t.getTravelType().equals(TravelEnum.TRAVEL_DAILY))
				allDailyTravel.add(t);
				
		}
		return allDailyTravel;
	}
	
	
	public ArrayList<Travel> findAllMiscTravelCost(){
		TravelDao td = new TravelDao();
		allMiscTravel = new ArrayList<Travel>();
		allTravel = td.displayTravel();
		for(Travel t:allTravel)
		{
			if(t.getTravelType().equals(TravelEnum.TRAVEL_MISC))
				allMiscTravel.add(t);
				
		}
		return allMiscTravel;
	}
	
	public ArrayList<Food> findAllFoodCost(){
		FoodDao td = new FoodDao();
		getAllFoodExpenses = td.displayAllFood();
		return getAllFoodExpenses;
	}
	
	
	public ArrayList<Food> findAllDailyFoodCost(){
		FoodDao td = new FoodDao();
		getAllDailyFoodExpenses = td.displayAllDailyFood();
		return getAllDailyFoodExpenses;
	}
	
	
	public ArrayList<Food> findAllMiscFoodCost(){
		FoodDao td = new FoodDao();
		getAllMiscFoodExpenses = td.displayAllMiscFood();
		return getAllMiscFoodExpenses;
	}

	public ArrayList<Food> findAllRestFoodCost() {
		FoodDao td = new FoodDao();
		getAllRestFoodExpenses =  td.displayAllRestFood();
		return getAllRestFoodExpenses;
	}
	
	
	
	
	
	public ArrayList<Movie> getAllMovie(){
		MovieDao md = new MovieDao();
		allMovies = md.dipslayAllMovies();
		return allMovies;
	}
	
	public double totalCostByMonth(int month){
		
		double totalCost=0,total = 0;
		allMovies = this.getAllMovie();
		allTravel = this.findAllTravelCost();
		allGifts = this.Allgifts();
		getAllFoodExpenses = this.findAllFoodCost();
		
		for(Movie m:allMovies){
			if(m.getMonth() == month)
				totalCost+=m.getTicketPrice();
		}
		total = totalCost;
		
		System.out.println("Movies Cost: "+totalCost);
		totalCost = 0;
		for(Travel t : allTravel){
			if(t.getMonth() == month)
				totalCost+=t.getTravelAmount();
		}
		total+=totalCost;
		
		System.out.println("Travel Cost: "+totalCost);
		totalCost =0;
		for(Food f :getAllFoodExpenses){
			if(f.getMonth() == month)
				totalCost+=f.getFoodPrice();
		}
		System.out.println("Food Cost: "+totalCost);
		total+=totalCost;
		totalCost = 0;
		for (Gift f:allGifts){
			if(f.getMonth() == month)
				totalCost+=f.getGiftAmount();
		}
		System.out.println("Gift Cost: "+totalCost);
		total+=totalCost;
		return total;
	}
	
	
	public ArrayList<Gift> Allgifts(){
		GiftDao gd = new GiftDao();
		return gd.displayAllGifts();
	}
	
}
