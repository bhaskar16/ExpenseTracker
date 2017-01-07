package com.dao;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.bean.Gift;
import com.bean.Movie;
import com.util.GiftEnum;

public class GiftDao {
	private ArrayList<Gift> allGifts;
	public ArrayList<Gift> displayAllGifts(){

		String csvFile = "D://Test//Gifts.txt";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        allGifts = new ArrayList<Gift>();
       
        
        try{
        	  br = new BufferedReader(new FileReader(csvFile));
              while ((line = br.readLine()) != null) {
              	Gift fb = new Gift();
                  // use comma as separator
                String[] Gifts = line.split(cvsSplitBy);
            
                try{
                	switch(Gifts[0]){
                	case "Office" :{
                		fb.setGiftOccasion(GiftEnum.GIFT_OFFICE);
                		break;
                	}
                	case "Friends":{
                		fb.setGiftOccasion(GiftEnum.GIFT_FRIENDS);
                		break;
                	}
                	case "Family":{
                		fb.setGiftOccasion(GiftEnum.GIFT_FAMILY);
                		break;
                	}
                	case "Relatives":{
                		fb.setGiftOccasion(GiftEnum.GIFT_RELATIVES);
                		break;
                	}
                	}
                	
                	fb.setGiftAmount(Double.parseDouble(Gifts[1]));
                	fb.setGiftTo(Gifts[2]);
                	fb.setMonth(Integer.parseInt(Gifts[3]));
                	fb.setYear(Integer.parseInt(Gifts[4]));
                	allGifts.add(fb);
              
               
                }
                catch(Exception e){
                	continue;
                }
        }
        }catch(Exception e){
        	

        }
		
		
		return allGifts;
	}
	
	public void writeGift(Gift f) throws IOException{
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter("D://Test//Gifts.txt",true));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append(f.getGiftOccasion()+",");
        sb.append(f.getGiftAmount()+",");
        sb.append(f.getGiftTo()+",");
        sb.append(f.getMonth()+",");
        sb.append(f.getYear());
        
        sb.append("\n");
        out.newLine();
        out.write(sb.toString());
        out.newLine();out.close();
	}

}
