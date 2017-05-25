package utilities;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;

class DateUtility {
	
	private LocalDate dateToday;
	private LocalDate dateDefaultExp;
	private LocalDate dateExpire;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	public LocalDate getDateToday(){
		return dateToday = LocalDate.now();
	}//end getDateToday
	
	public LocalDate getDateExp(){
		dateToday = LocalDate.now();
		dateDefaultExp = dateToday.plus(2, ChronoUnit.WEEKS);
		return dateDefaultExp;	
	}//end getDateExp dateDefaultExp
	
	public LocalDate getDateExp(String givenExpDate){
		dateToday = LocalDate.now();
		dateExpire = LocalDate.parse(givenExpDate, DateTimeFormatter.ISO_LOCAL_DATE);
	
		return dateExpire;
	}//end getDateExp givenExpDate
	
		/*
		public static void main(String[] args) {
	    	DateUtility test = new DateUtility();
	        LocalDate today = LocalDate.now();
	        System.out.println("Current date: " + test.getDateToday());

	        //add 2 week to the current date
	        System.out.println("Default two week experation: " + test.getDateExp());
	        
	        System.out.println("Given an exp date of \"2017-06-09\": " + test.getDateExp("2017-06-09"));
	    }*/
}//end DateUtility