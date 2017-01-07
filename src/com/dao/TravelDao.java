package com.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;

import com.bean.Travel;
import com.util.TravelEnum;

public class TravelDao {
	public ArrayList<Travel> displayTravel(){

        String csvFile = "D://Test//Travels.txt";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        
        ArrayList<Travel> allTravels = new ArrayList<Travel>();
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
            	Travel b = new Travel();
                // use comma as separator
                String[] Travels = line.split(cvsSplitBy);
              //  System.out.println(Travels[0]+" "+Travels[1]+" "+Travels[2]);
               // System.out.println("Travel [TravelName= " + Travels[0] + " , amount=" + Travels[1] + "]");
                try{
                b.setTravelAmount(Double.parseDouble(Travels[1]));
                b.setTravelDay(Integer.parseInt(Travels[2]));
                b.setMonth(Integer.parseInt(Travels[3]));
                }
                catch(Exception e){
                	
                }
                //b.setTravelYear(2016);
               
                /*if(monthDiff>0)
                	b.setTravelPaid(false);
                else
                	b.setTravelPaid(true);*/
                switch(Travels[0]){
                case "Daily":{
                	b.setTravelType(TravelEnum.TRAVEL_DAILY);
                	break;
                }
                case "Misc":{
                	b.setTravelType(TravelEnum.TRAVEL_MISC);
                	break;
                }
                default:{
                	b.setTravelType(TravelEnum.TRAVEL_MISC);
                	break;
                }
                }
                allTravels.add(b);
            }

        } catch (FileNotFoundException e) {
            
        } catch (IOException e) {
           
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                   
                }
            }
        }
        return allTravels;
	}
	
	public boolean writeTravel(Travel t) throws IOException{
			
		
		
		    BufferedWriter out = new BufferedWriter(new FileWriter("D://Test//Travels.txt",true));
		
		    
		
	        StringBuilder sb = new StringBuilder();
	        sb.append("\n");
	        
	        if(t.getTravelType().toString().equals("TRAVEL_DAILY"))
	        	sb.append("Daily,");
	        else
	        	sb.append("Misc,");
	        sb.append(""+t.getTravelAmount()+",");
	        sb.append(""+t.getTravelDay()+",");
	        sb.append(t.getMonth());
	        
	        
	        out.write(sb.toString());
	        out.newLine();out.close();
	        
	        System.out.println("done!");
		
		return false;
		
	}
	
	public int monthDiff(int month){
		
		 	Calendar now = Calendar.getInstance();
		 	
		 	 int m = now.get(Calendar.MONTH) + 1;
		    // 
		   // System.out.println("Current Year is : " + now.get(Calendar.YEAR));
		    // month start from 0 to 11
		    //System.out.println("Current Month is : " + (now.get(Calendar.MONTH) + 1));
		   
		    //System.out.println("Current Date is : " + now.get(Calendar.DATE));
		    
		    
		return month-m;
	}

}
