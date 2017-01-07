import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

import com.bean.*;
import com.dao.BillDao;
import com.dao.FoodDao;
import com.dao.GiftDao;
import com.dao.MovieDao;
import com.dao.TravelDao;
import com.util.BillEnum;
import com.util.FoodEnum;
import com.util.GiftEnum;
import com.util.TravelEnum;



public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		flowOfControl();
		
		
	}
	
	public static void flowOfControl(){
		System.out.println("Welcome to expense tracker \n");
		System.out.println();
		System.out.println();
		boolean flag = true;
		while(flag){
			System.out.println("1. Food Expense Track");
			System.out.println("2. Travel Expense Track");
			System.out.println("3. Bills Expense Track");
			System.out.println("4. Movies Expense Track");
			System.out.println("5. Record Expense");
			System.out.println("6. All Expenses in a month");
			System.out.println("7. Gifts Expense Track");
			System.out.println("EXIT: Close");
			
			Scanner sc=new Scanner(System.in);  
			String choice = sc.next();
			
			switch(choice){
			case "1":{
				foodFlow();
				break;
			}
			case "2":{
				travelFlow();
				break;
			}
			case "3":{
				billFlow();
				break;
			}
			case "4":{
				movieFlow();
				break;
			}
			case "5":{
				writeExpenseFlow();
				break;
			}
			case "6":{
				AllExpenses();
				break;
			}
			case "7":{
				giftFlow();
				break;
			}
			case "Exit":{
				flag = false;
				break;
			}
			default:break;
			}
		}
	}
	
	private static void giftFlow() {
		
		
		ExpenseTracker et = new ExpenseTracker();
		Scanner sc=new Scanner(System.in);
		System.out.println("1. All Gifts");
		System.out.println("2. Family Gifts");
		System.out.println("3. Relative Gifts");
		System.out.println("4. Office Gifts");
		System.out.println("5. Friends Gifts");
		System.out.println("6. Gifts to Self");
		System.out.println("7. Write Gift Record");
		String choice = sc.next();
		switch(choice){
		case "1":{
			ArrayList<Gift> af = et.Allgifts();
			double cost = 0;
			for (Gift f: af){
				System.out.println(f);
				cost+=f.getGiftAmount();
			}
				System.out.println("Total Cost: "+cost);
			break;
			}
		case "7":{
			sc=new Scanner(System.in);
			sc.nextLine();
			System.out.println("Enter Gift Type");
			String gType = sc.nextLine();
			System.out.println("Enter Gift recipient");
			String gTo = sc.nextLine();
			System.out.println("Enter Gift price");
			double gPrice = sc.nextDouble();
			System.out.println("Enter Gift month");
			int gMonth = sc.nextInt();
			System.out.println("Enter Gift year");
			int gyear = sc.nextInt();
			GiftEnum gEnum= GiftEnum.GIFT_FAMILY;
			switch(gType){
			case "Friends":{
				gEnum = GiftEnum.GIFT_FRIENDS;
				break;
			}
			case "Relatives":{
				gEnum = GiftEnum.GIFT_RELATIVES;
				break;
			}
			case "Office":{
				gEnum = GiftEnum.GIFT_OFFICE;
				break;
			}
			}
			Gift newGift = new Gift();
			newGift.setGiftOccasion(gEnum);
			newGift.setGiftAmount(gPrice);
			newGift.setGiftTo(gTo);
			newGift.setMonth(gMonth);
			newGift.setYear(gyear);
			
			GiftDao gd = new GiftDao();
			try {
				gd.writeGift(newGift);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		}
		
	}

	private static void AllExpenses() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Month");
		String choice = sc.next();
		ExpenseTracker et = new ExpenseTracker();
		double TotalCost = et.totalCostByMonth(Integer.parseInt(choice));
		System.out.println("Total cost in the given month: "+TotalCost);
		Budget b = new Budget();
		System.out.println("Permissible amount in budget: "+b.trackBudget(TotalCost));
	}

	private static void movieFlow() {
		
		boolean flag = true;
		while(flag){
		System.out.println("1. Write Movie Expense");
		System.out.println("2. Display all Movie Expenses");
		ExpenseTracker et = new ExpenseTracker();
		Scanner sc=new Scanner(System.in);  
		String choice = sc.next();
		switch(choice){
		case "1":{
			sc.nextLine();
			System.out.println("Enter Movie Name");
			String Moviename = sc.nextLine();
			
			System.out.println("Enter Theatre");
			
			String theatre = sc.nextLine();
			System.out.println("Enter Month");
			int month = Integer.parseInt(sc.nextLine());
			System.out.println("Enter Price of ticket");
			double price = Double.parseDouble(sc.nextLine());
			MovieDao md = new MovieDao();
			Movie m = new Movie();
			m.setMonth(month);
			m.setMovieName(Moviename);
			m.setMovieTheatre(theatre);
			m.setTicketPrice(price);
			try {
				md.writeMovie(m);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Error");
			}
			break;
		}
		case "2":{
			ArrayList<Movie> allMovies = et.getAllMovie();
			double cost =0;
			for(Movie m : allMovies){
				System.out.println(m);
				cost+=m.getTicketPrice();
			}
			System.out.println("Total: "+cost);
				
		}
		}
		}
	}

	public static void writeExpenseFlow() {
		boolean flag = true;
		while(flag){
		System.out.println("1. Write Travel Expense");
		System.out.println("2. Write Food Expense");
		System.out.println("3. Write Bill Expense");
		System.out.println("4. Exit");
		Scanner sc=new Scanner(System.in);  
		String choice = sc.next();
		switch(choice){
		
		case "1":{
			System.out.println("Enter Travel Type");
			String type = sc.next();
			System.out.println("Enter date");
			String date = sc.next();
			System.out.println("Enter month");
			String month = sc.next();
			System.out.println("Enter amount");
			String amount = sc.next();
			Travel t = new Travel();
			
			if(type.equalsIgnoreCase("Daily"))
				t.setTravelType(TravelEnum.TRAVEL_DAILY);
			else if(type.equalsIgnoreCase("Misc"))
				t.setTravelType(TravelEnum.TRAVEL_MISC);
			
			t.setTravelDay(Integer.parseInt(date));
			
			//	t.setMonth(-1);//Change here
			
			t.setMonth(Integer.parseInt(month));
			
				//t.setTravelAmount(0);
		
			t.setTravelAmount(Double.parseDouble(amount));
			
			TravelDao td = new TravelDao();
			try {
				td.writeTravel(t);
			} catch (IOException e) {
				System.out.println("Could not write");
			}
			finally{
				td.displayTravel();
			}
		}
		case "2":{
			System.out.println("Enter Food Expense Type");
			String type = sc.next();
			System.out.println("Enter date");
			String date = sc.next();
			System.out.println("Enter month");
			String month = sc.next();
			System.out.println("Enter amount");
			String amount = sc.next();
			System.out.println("Enter Restaurant Name");
			String rest = sc.next();
			Food f = new Food();
			
			if(type.equalsIgnoreCase("Daily"))
				f.setFoodType(FoodEnum.FOOD_DAILY);
			else if(type.equalsIgnoreCase("Misc"))
				f.setFoodType(FoodEnum.FOOD_MISC);
			else if(type.equalsIgnoreCase("Rest"))
				f.setFoodType(FoodEnum.FOOD_RESTAURANT);
			f.setDay(Integer.parseInt(date));
			
			//	t.setMonth(-1);//Change here
			
			f.setMonth(Integer.parseInt(month));
			
				//t.setTravelAmount(0);
		
			f.setFoodPrice(Double.parseDouble(amount));
			f.setRestaurantName(rest);
			
			FoodDao td = new FoodDao();
			try {
				td.writeFood(f);
			} catch (IOException e) {
				System.out.println("Could not write");
			}
			finally{
				td.displayAllFood();
			}
		}
		}
		
		
		}
		
	}

	public static void foodFlow(){
		ExpenseTracker et = new ExpenseTracker();
		boolean flag = true;
		while(flag){
		System.out.println("1. Display all food Cost");
		System.out.println("2. Display all Daily food Cost");
		System.out.println("3. Display all Misc food Cost");
		System.out.println("4. Display all Restaurant food Cost");
		
		Scanner sc=new Scanner(System.in);  
		String choice = sc.next();
		switch(choice){
		case "1":{
			ArrayList<Food> foods = et.findAllFoodCost();
			Collections.sort(foods,new FoodComparator(Food.FoodMonthComparator,Food.FoodNameComparator));
			double cost = 0;
			for(Food fd : foods){
				System.out.println(fd);
				cost+=fd.getFoodPrice();
			}
			System.out.println("Total: "+cost);
			break;
		}
		case "2":{
			ArrayList<Food> foods = et.findAllDailyFoodCost();
			double cost =0;
			for(Food fd : foods){
				System.out.println(fd);
				cost+=fd.getFoodPrice();
			}
			System.out.println("Total: "+cost);
			break;
		}
		case "3":{
			double cost =0;
			ArrayList<Food> foods = et.findAllMiscFoodCost();
			for(Food fd : foods){
				System.out.println(fd);
				cost+=fd.getFoodPrice();
			}
			System.out.println("Total: "+cost);
			break;
		}
		case "4":{
			double cost =0;
			ArrayList<Food> foods = et.findAllRestFoodCost();
			for(Food fd : foods){
				System.out.println(fd);
				cost+=fd.getFoodPrice();
			}
			System.out.println("Total: "+cost);
			break;
		}
		case "Exit":{
			flag = false;
			break;
		}
		default :break;
		}
		
		}
	}
	
	public static void travelFlow(){
		ExpenseTracker et = new ExpenseTracker();
		boolean flag = true;
		while(flag){
			System.out.println("1. All Travel Cost");
			System.out.println("2. Daily travel Cost");
			System.out.println("3. Misc travel Cost");
		
		Scanner sc=new Scanner(System.in);  
		String choice = sc.next();
		switch(choice){
		case "1":{
			double cost =0;
			ArrayList<Travel> allTravel = et.findAllTravelCost();
			for(Travel t1 : allTravel){
				System.out.println(t1);
				cost+=t1.getTravelAmount();
			}

			System.out.println("Total: "+cost);
			break;
		}
		case "2":{
			ArrayList<Travel> allTravel = et.findAllDailyTravelCost();
			double cost =0;
			for(Travel t1 : allTravel){
				System.out.println(t1);
				cost+=t1.getTravelAmount();
			}

			System.out.println("Total: "+cost);
			break;
			
			
		}
		case "3":{
			ArrayList<Travel> allTravel = et.findAllMiscTravelCost();
			double cost =0;
			for(Travel t1 : allTravel){
				System.out.println(t1);
				cost+=t1.getTravelAmount();
			}
			System.out.println("Total: "+cost);
			break;
			
			
		}
		}
		}
		
	}
	public static void billFlow(){
		ExpenseTracker et = new ExpenseTracker();
		boolean flag = true;
		while(flag){
			System.out.println("1. Show All Bills");
			System.out.println("2. Show Paid Bills");
			System.out.println("3. Show Unpaid Bills");
			System.out.println("4. Show Bills Month Wise");
			System.out.println("5. Show Specific Bill");
			System.out.println("6. Show Bills in order");
		
		Scanner sc=new Scanner(System.in);  
		String choice = sc.next();
		switch(choice){
		case "1":{
			ArrayList<Bill> allBills= et.getAllBills();
			double amountTotal = 0;
			for(Bill b : allBills){
				System.out.println(b);
				amountTotal += b.getBillAmount();
				
			}
			System.out.println(amountTotal);
			break;
			
			
		}
		case "2":{
			ArrayList<Bill> allBills= et.getAllPaidBills();
			double amountTotal = 0;
			for(Bill b : allBills){
				System.out.println(b);
				amountTotal += b.getBillAmount();
				
			}
			System.out.println(amountTotal);
			break;
			
		}
		case "3":{
			ArrayList<Bill> allBills= et.getAllUnpaidBills();
			double amountTotal = 0;
			for(Bill b : allBills){
				System.out.println(b);
				amountTotal += b.getBillAmount();
				
			}
			System.out.println(amountTotal);
			break;
		}
		case "4":{
		HashMap<Integer,ArrayList<Bill>> hp = et.getBillsByMonth();
		//DONT USE://LinkedHashMap <Integer,Bill> hp = et.getBillsByMonthLinked();
		for(Integer i:hp.keySet())
			System.out.println(i+"   "+hp.get(i));
			
		break;
		}
		
		case "5":{
			ArrayList<Bill> allBills = new ArrayList<Bill>();
			System.out.println("Enter Bill");
			String b = sc.next();
			if(b.equalsIgnoreCase("netflix"))
				allBills = (et.getSpecificBill(BillEnum.NETFLIX));
			else if(b.equalsIgnoreCase("airtel"))
				allBills = (et.getSpecificBill(BillEnum.AIRTEL_PHONE));
			else if(b.equalsIgnoreCase("docomo"))
				allBills = (et.getSpecificBill(BillEnum.DOCOMO_PHONE));
			else if(b.equalsIgnoreCase("internet"))
				allBills = (et.getSpecificBill(BillEnum.INTERNET));
			for(Bill bill:allBills)
				System.out.println(bill);
		break;
		}
		case "6":{
			System.out.println("1. Sort by Amount");
			System.out.println("2. Sort by Date");
			System.out.println("3. Sort by name");
			ArrayList<Bill> allBills= et.getAllBills();
			double amountTotal = 0;
			String ch = sc.next();
			switch(ch){
			case "1":{
				Collections.sort(allBills);
				break;
			}
			case "2":{
				Collections.sort(allBills,Bill.BillDateComparator);
				break;
			}
			case "3":{
				Collections.sort(allBills,Bill.BillNameComparator);
				break;
			}
			}
			
			
			for(Bill b : allBills){
				System.out.println(b);
				amountTotal += b.getBillAmount();
				
			}
			System.out.println(amountTotal);
			break;
		}
		
		}
		
	}
	}

}
