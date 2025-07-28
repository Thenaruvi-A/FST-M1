package javaactivities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Plane {
	private List<String> passengers;
    private int maxPassengers;
    private Date lastTimeTookOf;
    private Date lastTimeLanded;
    
// constructor
	public Plane(int maxPassengers) {
		   this.passengers= new ArrayList<>(); //instantiation
		   this.maxPassengers=maxPassengers; //Initialization

	}

 
    public void onboard(String passengerName) {
    	if (passengers.size() <= maxPassengers) {   //Array list inbuilt methods
    		this.passengers.add(passengerName);}
    		else {
    			System.out.println("Is Full");
    		}
    	}
    public Date takeOff() {
    	 this.lastTimeTookOf = new Date();
         return lastTimeTookOf; // returns the current date and time
    }
    public void land() {
    	 this.lastTimeLanded = new Date();
         this.passengers.clear(); //lastTimeLanded to the current date and time.clear() the array.
    }
    
    public Date getLastTimeLanded() {
    	  return lastTimeLanded; //returns the value of lastTimeLanded.
    }
    
    public List<String> getPassengers() {
    	return passengers; // : returns the array of passengers.
    }
   
}
