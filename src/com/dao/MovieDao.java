package com.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.bean.Movie;
import com.bean.Movie;


public class MovieDao {
	private ArrayList<Movie> allMovies;
	
	public ArrayList<Movie> dipslayAllMovies(){
		
		String csvFile = "D://Test//Movie.txt";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        allMovies = new ArrayList<Movie>();
       
        
        try{
        	  br = new BufferedReader(new FileReader(csvFile));
              while ((line = br.readLine()) != null) {
              	Movie fb = new Movie();
                  // use comma as separator
                String[] Moviebills = line.split(cvsSplitBy);
            /*   System.out.println(Moviebills[0]);
               System.out.println(Moviebills[1]);
               System.out.println(Moviebills[2]);*/
                try{
               fb.setMovieName(Moviebills[0]);
              
               fb.setMovieTheatre(Moviebills[1]);
               fb.setMonth(Integer.parseInt(Moviebills[2]));
               fb.setTicketPrice(Double.parseDouble(Moviebills[3]));
                allMovies.add(fb);
               
                }
                catch(Exception e){
                	
                }
        }
        }catch(Exception e){
        	e.printStackTrace();

        }
		
		
		return allMovies;
	}
	
	public void writeMovie(Movie m) throws IOException{
		 	BufferedWriter out = null;
			try {
				out = new BufferedWriter(new FileWriter("D://Test//Movie.txt",true));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		    StringBuilder sb = new StringBuilder();
	        sb.append("\n");
	        sb.append(m.getMovieName()+",");
	        sb.append(m.getMovieTheatre()+",");
	        sb.append(m.getMonth()+",");
	        sb.append(m.getTicketPrice());
	        sb.append("\n");
	        out.newLine();
	        out.write(sb.toString());
	        out.newLine();out.close();
	        
	}

}
