package com.bean;

public class Movie implements Expense {
	
	private String movieName;
	private String movieTheatre;
	private double ticketPrice;
	private int month;
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieTheatre() {
		return movieTheatre;
	}
	public void setMovieTheatre(String movieTheatre) {
		this.movieTheatre = movieTheatre;
	}
	public double getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	@Override
	public String toString() {
		return "Movie [movieName=" + movieName + ", movieTheatre="
				+ movieTheatre + ", ticketPrice=" + ticketPrice + ", month="
				+ month + "]";
	}
	
	

}
