package com.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import com.bean.Bill;
import com.util.BillEnum;

public class BillDao {
	public ArrayList<Bill> displayBill(){

        String csvFile = "D://Test//Bills.txt";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        
        ArrayList<Bill> allBills = new ArrayList<Bill>();
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
            	Bill b = new Bill();
                // use comma as separator
                String[] bills = line.split(cvsSplitBy);
              //  System.out.println(bills[0]+" "+bills[1]+" "+bills[2]);
               // System.out.println("Bill [billName= " + bills[0] + " , amount=" + bills[1] + "]");
               
                b.setBillAmount(Double.parseDouble(bills[1]));
                b.setBillMonth(Integer.parseInt(bills[2]));
                b.setBillYear(2016);
                int monthDiff = monthDiff(Integer.parseInt(bills[2]));
                if(monthDiff>0)
                	b.setBillPaid(false);
                else
                	b.setBillPaid(true);
                switch(bills[0]){
                case "Netflix":{
                	b.setBillName(BillEnum.NETFLIX);
                	break;
                }
                case "Airtel":{
                	b.setBillName(BillEnum.AIRTEL_PHONE);
                	break;
                }
                case "Internet":{
                	b.setBillName(BillEnum.INTERNET);
                	break;
                }
                }
                allBills.add(b);
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
        return allBills;
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
